# Principios SOLID

## Ejercicio práctico - Rut Navarro Hernández

### Principios SOLID que incumple el código:
- Principio de Responsabilidad Única
- Principio de Segregación de Interfaces
- Principio de Abierto / Cerrado

La clase `File` tiene varias responsabilidades, como leer y escribir en un archivo, abrir y cerrar un archivo, 
y convertir el formato.

Si en un futuro quisieramos añadir un nuevo formato a convertir tendriamos que modificar la clase `File`.
Para cumplir con el **principio abierto/cerrado**, he creado una nueva interfaz `FileConverter` la cuál contiene el método `convert`
y además he creado 2 clases `FileConverterMp3ToWavImpl` y `FileConverterWavToMp3Impl` las cuales implementan
esta interfaz.

Además la interfaz `FileSystemItem` contiene métodos que no son relevantes para ciertas clases que la implementan. 
Ya que contiene métodos que no utilizan estas.

Para cumplir con el **principio de responsabilidad única** y el **principio de segregación de interfaces**, he separado estos métodos en varias interfaces.

> - `FileSystemItem`: Contiene los métodos comúnes tanto de un File como de un Directory.
  Es implementada por FileSystemItemBase.
> - `FileSystemDirectory`: Contiene los métodos relacionados con un Directory.
  Es implementada por la clase Directory.
> - `FileSystemFile`: Contiene los métodos relacionados con un File.
  Es implementada por la clase File.

Con esto conseguimos que cada clase implemente los métodos necesarios según el tipo de objeto.
