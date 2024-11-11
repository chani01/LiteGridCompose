package com.chani.litegridcompose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LiteGrid (
    modifier: Modifier = Modifier,
    columns: Int = 2,
    spacing: Dp = 8.dp, // 아이템 간의 간격 설정
    horizontalCenterAlignment: Boolean = false, // 가로 중앙 정렬 옵션
    content: @Composable () -> Unit
){
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        // 아이템 폭과 간격을 고려하여 각 아이템의 최대 폭을 계산
        val totalHorizontalSpacing = (columns - 1) * spacing.roundToPx()
        val itemWidth = (constraints.maxWidth - totalHorizontalSpacing) / columns
        val itemConstraints = constraints.copy(
            minWidth = itemWidth,
            maxWidth = itemWidth
        )

        // 각 아이템 측정
        val placeables = measurables.map { it.measure(itemConstraints) }

        // 각 열의 높이 저장 배열
        val columnHeights = IntArray(columns) { 0 }
        placeables.forEachIndexed { index, placeable ->
            val column = index % columns
            columnHeights[column] += placeable.height + spacing.roundToPx()
        }

        // 전체 높이 계산 (가장 높은 열을 기준으로)
        val height = columnHeights.maxOrNull()?.coerceAtMost(constraints.maxHeight)
            ?: constraints.minHeight

        val totalGridWidth = (itemWidth * columns) + totalHorizontalSpacing

        // 아이템이 가운데 정렬되도록 전체 가로 오프셋을 계산
        val xOffset = if (horizontalCenterAlignment) {
            (constraints.maxWidth - totalGridWidth) / 2
        } else 0

        layout(
            width = constraints.maxWidth,
            height = height
        ) {
            // 각 열의 누적 높이 저장 배열
            val columnY = IntArray(columns) { 0 }

            placeables.forEachIndexed { index, placeable ->
                val column = index % columns
                // 아이템 위치 배치
                placeable.placeRelative(
                    x = xOffset + column * (itemWidth + spacing.roundToPx()),
                    y = columnY[column]
                )
                columnY[column] += placeable.height + spacing.roundToPx()
            }
        }
    }
}