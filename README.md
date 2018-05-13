# Call Center

Existe un call center donde hay 3 tipos de empleados: operador, supervisor
y director. El proceso de la atención de una llamada telefónica en primera
instancia debe ser atendida por un operador, si no hay ninguno libre debe
ser atendida por un supervisor, y de no haber tampoco supervisores libres
debe ser atendida por un director.

# Solución

Para solucionar el problema usando concurrencia se utilizó la clase 
ExecutorService de Java, para administrar las llamadas concurrentes. 

Se creo una clase empleado la cual tiene un tipo con tres posibles valores: operador, supervisor, director. 
Cada uno de estos tipos de empleado tiene una prioridad dentro del proceso de manejo de llamadas del call center,
la cual utiliza una cola prioridad (PriorityBlockingQueue), ya que esto optimiza el manejo los empleados delegando 
la logica a la cola.

SOLUCION DE PUNTOS OPCIONALES:

Al usar la clase ExecutorService y dejar que esta administre las llamadas concurrentes,
si el pool de hilos esta lleno, El maneja una cola interna donde almacena las llamadas 
que no han podido ser antendidas. Tan pronto un hilo se desocupa una de las llamadas
encolodas es atendida.

# Autor
Diego Sánchez 


    

 