## HITO EVALUATIVO N°1 – ICC700

### 20-04-2024

1. La evaluación es de carácter individual, por lo que cualquier sospecha de copia será calificado con nota 1.0.
2. La evaluación tiene una duración de 2.5 horas.
3. Debe realizar el análisis y desarrollo del problema. Dispone de 30 minutos para el análisis (9.30 hrs. Cierre actividad) y de 2.0 horas para realizar el diseño (11.30 hrs. Cierre actividad).
4. Recuerde que el Desarrollo debe realizarlo en PseInt.
5. Asuma el enunciado como cierto. Cualquier supuesto utilizado (frente a situaciones no descritas en el enunciado), declárelo como comentario en su respuesta.
6. Debe validar las entradas.

A pesar de la disminución en la inflación durante el 2024, los efectos de conflictos internacionales, como las guerras, continúan ejerciendo una influencia directa en el costo de vida. Entre los estudiantes universitarios, una preocupación común son los llamados "gastos hormiga", pequeños desembolsos que, acumulados a lo largo del día, afectan significativamente la economía personal. Dado que tanto usted como sus compañeros se enfrentan diariamente a diversos gastos, se ha decidido desarrollar una herramienta de apoyo financiero para controlar estos gastos hormiga. Para ello, utilizará PSeInt en una primera iteración del proyecto.

El sistema requerirá que cada estudiante ingrese al inicio un presupuesto con el monto total máximo disponible para gastar. El sistema permitirá al usuario registrar el monto gastado en cada compra, junto con la categoría en la que se realizó el gasto, con el fin de mantener una estructura adecuada de gastos.

El sistema debe ser capaz de manejar un número ilimitado de gastos, hasta que el usuario indique que no desea realizar más registros o hasta que se haya agotado el dinero disponible. Una vez finalizados los registros, el sistema debe proporcionar:

-  El total gastado en cada una de las tres categorías (transporte, comida, ocio).
-  La determinación de la categoría con el mayor gasto.
-  El total general de gastos.
-  La cantidad de dinero restante al final del proceso en comparación con el monto inicialmente ingresado en el sistema.

El sistema debe permitir que un número ilimitado de estudiantes ingrese sus datos y proporcionar la información anterior para cada uno. Una vez que el programa haya finalizado completamente (es decir, no haya más estudiantes por ingresar), el sistema debe calcular y presentar el promedio general por categoría, además del total general.

**Restricciones del sistema:**

-  El usuario debe ingresar al inicio del sistema el monto total sobre el cual desea distribuir sus gastos.
-  Existe un límite máximo de gasto por categoría, siendo este límite proporcional al monto ingresado por el usuario. Las categorías de transporte, comida y ocio tendrán una distribución del 40%, 30% y 30% respectivamente con respecto al total del dinero disponible.
