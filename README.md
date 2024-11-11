# LiteGrid

**LiteGrid** is a flexible and customizable grid layout for Jetpack Compose. It provides an easy way to create grid-based layouts with control over spacing, alignment, and item arrangement.

---

## 🌟 Features
- **Customizable Columns**: Define the number of columns in the grid.
- **Spacing Control**: Easily adjust the spacing between grid items.
- **Horizontal Center Alignment**: Option to center-align the grid within its parent.
- **Dynamic Layouts**: Automatically arranges items based on the number of columns and constraints.

---

## 🚀 Installation

[![GitHub release (latest by date)](https://img.shields.io/github/v/release/chani01/LiteGridCompose?label=Latest%20Version)](https://github.com/chani01/LiteGridCompose/releases)

Add the following dependency to your `build.gradle` file once the library is published:

```gradle
dependencies {
    implementation 'com.chani01:LiteGridCompose:<latest_version>'
}
```

---

## 📖 Usage

### Basic Usage

Here’s how to use **LiteGrid** in your Composable functions:

```kotlin
@Composable
fun SampleGrid() {
    LiteGrid(
        columns = 3,
        spacing = 16.dp,
        horizontalCenterAlignment = true
    ) {
        // Add your grid items here
        repeat(9) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.LightGray)
            )
        }
    }
}
```

### Parameters

- **`modifier`**: Allows customization of the grid's modifier.
- **`columns`**: Number of columns in the grid. Default is `2`.
- **`spacing`**: Spacing between grid items. Default is `8.dp`.
- **`horizontalCenterAlignment`**: Aligns the grid horizontally in the parent if set to `true`. Default is `false`.
- **`content`**: The composable content of the grid.

---

## 📦 Layout Behavior

- **Responsive Item Sizing**: Each item’s width is automatically adjusted based on the total available width and the number of columns.
- **Column Heights**: Items are placed in columns with dynamic heights based on their content.

---

## 🛠️ Configuration

You can customize the grid layout easily using the provided parameters. For example, adjust spacing or column count to achieve your desired layout:

```kotlin
LiteGrid(
    columns = 4,
    spacing = 12.dp,
    horizontalCenterAlignment = false
) {
    // Grid content
}
```

---

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](./LICENSE) file for details.

---

## 🙌 Contributions

Contributions are welcome! Feel free to open issues, submit pull requests, or suggest new features. 😊

---
