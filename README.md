# Cafetería - Calculadora de descuentos

Proyecto integrador de Programación Orientada a Objetos II (IU Digital de Antioquia).

Aplicación en Java que calcula el descuento de un pedido de la cafetería.
Si el total es mayor a $10 se aplica un 15 % de descuento. Si no, el descuento es 0.

## Qué usa
- Herencia y polimorfismo: `Producto`, `Bebida` y `Comida`.
- Interfaz funcional `ReglaDescuento` y una expresión lambda para el descuento.
- Ventana en Swing con `JTextField`, `JButton` y `JTextArea`.
- Conexión JDBC a SQLite con try-with-resources.

## Cómo correrlo en VS Code
1. Instalar el JDK 17 o superior y el "Extension Pack for Java".
2. Abrir esta carpeta en VS Code.
3. Abrir `src/cafeteria/Main.java` y darle clic a **Run**.

El driver de SQLite está en la carpeta `lib`. VS Code lo toma solo por el archivo `.vscode/settings.json`.

## Carpetas
- `src/cafeteria/modelo`: productos.
- `src/cafeteria/descuento`: reglas de descuento y calculadora.
- `src/cafeteria/datos`: conexión y consultas a la base de datos.
- `src/cafeteria/vista`: la ventana.
- `docs`: diagrama de clases, capturas e informe.
