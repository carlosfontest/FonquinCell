# FonquiCell [JAVA]

## ***Introducción***
Simulación del proceso de fabricación de los productos de una compañía de teléfonos celulares. Está basado en Hilos trabajando el problema del *Productor/Consumidor*, *Lector/Escritor* y la exclusión mutua con semáforos. Los valores iniciales de la simulación se insertan a través de un archivo JSON.


## ***ScreenShots***

### *Vista principal*
![Vista principal](https://i.ibb.co/ry0B7Dr/Fonquincell1.png)


## ***Especificaciones de desarrollo***
> Software desarrollado con el IDE *NetBeans*, en el lenguaje ***JAVA***


## ***Especificaciones del Sistema***
Una importante compañía de telefonos celulares lo ha contratado para realizar una
simulacion del proceso de fabricación de sus productos. Para ello, se le pide que realice
que desarrolle en Java dicha simulacion, la cual debe contener el uso de hilos, semáforos
y las soluciones conocidas a los problemas de productor/consumidor y lector/escritor.

Durante el proceso de fabricación se requieren dos tipos de empleados:

1. **Productores**: Encargados de producir las distintas partes necesarias para
ensamblar los celulares. Es necesario mencionar que tienen a su disposición
almacenes de capacidades finitas en los que guardan las piezas una vez están
listas. Antes de producir una pieza, un productor comprueba si existe espacio en el
almacén para guardarla. Existen tres grupos de productores:
    * **Productores de Baterias**: A un productor le toma 1 día producir 1 bateria.
El almacén que disponen cuenta con una capacidad inicial de 25 unidades.
Por normativa de la compañía, puede haber un máximo de 4 productores
de baterias en la fábrica, con una cantidad inicial de 2 productores.
    * **Productores de Pantallas**: A un productor le toma 2 días producir 1
pantalla. El almacén que disponen cuenta con una capacidad inicial de 30
unidades. Por normativa de la compañía, puede haber un máximo de 8
productores de pantallas en la fábrica, con una cantidad inicial de 3
productores.
    * **Productores de Cables de Conexion**: A un productor le toma 1 días
producir 1 unidad de cables de conexion. El almacén que disponen cuenta
con una capacidad inicial de 35 unidades. Por normativa de la compañía,
puede haber un máximo de 3 productores de cables de conexion en la
fábrica, con una cantidad inicial de 1 productor.

2. **Ensambladores**: Estos empleados tienen la responsabilidad de armar el producto
final, para que luego sea despachado de la fábrica. Para ello toman 2 cables de
conexion, 1 pantalla y 1 bateria de los respectivos almacenes. Una vez obtenidas
todas las piezas, a un ensamblador le toma 2 días realizar su trabajo. Al terminar,
el ensamblador tiene la responsabilidad de aumentar el contador de unidades
disponibles y guardarla junto a las demás. Puede haber un máximo de 5
ensambladores en la compañía.

Además, la fábrica cuenta también con:

3. **Cronometrador**: La única tarea del cronometrador es registrar el paso de los días.
El cronometrador posee un contador inicializado en el número de días que faltan
para el despacho. Cada día, el cronometrador disminuye su contador en una
unidad, lo que le toma 1,5 horas. Si hay alguien leyendo el contador cuando el
cronometrador va a modificarlo, él debe esperar a que el lector termine. Cuando el
contador vaya a pasar el valor 0, el cronometrador lo reinicializa. Hay solo 1
cronometrador en la compañía y solo 1 contador. El resto del tiempo, el
cronometrador está dormido.
4. **Gerente**: Cada día se dirige al contador, para verificar cuantos días faltan para el
despacho. Si el cronometrador está modificando el contador en ese momento, el
gerente espera a que él termine antes de leer. Si el contador es distinto a 0, el
gerente va a dormir, por un período aleatorio entre 6 y 18 horas. Si el contador es
igual a 0, el gerente manda a despachar las unidades finales disponibles,
reinicializando el contador.

Su programa deberá hacer uso de una interfaz gráfica que permita observar y
controlar el sistema. Se debe poder conocer en cualquier momento:

* La cantidad de productores de cada tipo.
* La cantidad de baterias, pantallas y cables de conexion disponibles en el
almacén.
* La cantidad de ensambladores.
* La cantidad de unidades finales disponibles.
* Los días que faltan para el despacho.
* Qué está haciendo el cronometrador.
* Qué estás haciendo el gerente.
* Cualquier otro dato que considere relevante.

La simulación debe permitir, en tiempo de ejecución:
* Contratar o despedir un productor de cualquiera de los tres tipos.
* Contratar o despedir un ensamblador.

Además, a través de un archivo (texto, objeto, csv o json), se le debe poder indicar al
programa los siguientes parámetros:
* Tiempo, en segundos, que dura un día en el programa.
* Cantidad de días entre despachos.
* La capacidades máximas para cada tipo de almacenes (No tome en cuenta el
almacén de los productos finales, para efectos de la simulación se considerará
capaz de contener cualquier cantidad de telefonos celulares)
* La cantidad inicial de productores de cada tipo.
* La cantidad máximo de productores de cada tipo.
* La cantidad inicial de ensambladores.
* La cantidad máxima de ensambladores.