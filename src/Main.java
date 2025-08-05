import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Estado> listaEstados = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=============================");
            System.out.println(" Máquina de Estados Finita ");
            System.out.println("=============================");
            System.out.println("1) Crear nuevo estado");
            System.out.println("2) Definir alfabeto de entrada");
            System.out.println("3) Definir alfabeto de salida");
            System.out.println("4) Establecer estado inicial");
            System.out.println("5) Crear transición (entrada, salida, siguiente estado)");
            System.out.println("6) Evaluar cadena de entrada");
            System.out.println("7) Ver estado actual");
            System.out.println("8) Graficar FSM (placeholder)");
            System.out.println("9) Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1": // Crear nuevo estado
                    Estado nuevo = new Estado();
                    listaEstados.add(nuevo);
                    System.out.println("Estado #" + (listaEstados.size() - 1) + " creado.");
                    break;

                case "2": // Alfabeto entrada
                    System.out.print("Ingrese los símbolos de entrada separados por espacios: ");
                    String[] entradas = scanner.nextLine().split(" ");
                    Estado.establecerEntrada(entradas);
                    System.out.println("Alfabeto de entrada establecido.");
                    break;

                case "3": // Alfabeto salida
                    System.out.print("Ingrese los símbolos de salida separados por espacios: ");
                    String[] salidas = scanner.nextLine().split(" ");
                    Estado.establecerSalida(salidas);
                    System.out.println("Alfabeto de salida establecido.");
                    break;

                case "4": // Estado inicial
                    if (listaEstados.isEmpty()) {
                        System.out.println("Primero debe crear al menos un estado.");
                        break;
                    }
                    System.out.print("Ingrese el número del estado inicial (0 a " + (listaEstados.size() - 1) + "): ");
                    int idxIni = Integer.parseInt(scanner.nextLine());
                    if (idxIni >= 0 && idxIni < listaEstados.size()) {
                        Estado.estadoInicial(listaEstados.get(idxIni));
                        System.out.println("Estado inicial definido.");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case "5": // Crear transición
                    if (listaEstados.isEmpty()) {
                        System.out.println("Primero cree estados.");
                        break;
                    }
                    System.out.print("Número del estado origen: ");
                    int origen = Integer.parseInt(scanner.nextLine());
                    System.out.print("Símbolo de entrada: ");
                    String entrada = scanner.nextLine();
                    System.out.print("Símbolo de salida: ");
                    String salida = scanner.nextLine();
                    System.out.print("Número del estado destino: ");
                    int destino = Integer.parseInt(scanner.nextLine());

                    if (origen < listaEstados.size() && destino < listaEstados.size()) {
                        listaEstados.get(origen).crearF(entrada, salida, listaEstados.get(destino));
                        System.out.println("Transición creada correctamente.");
                    } else {
                        System.out.println("Índices inválidos de estado.");
                    }
                    break;

                case "6": // Evaluar cadena
                    if (Estado.estadoActual == null) {
                        System.out.println("Primero defina un estado inicial.");
                        break;
                    }
                    System.out.print("Ingrese la cadena (símbolos separados por espacio): ");
                    String[] cadena = scanner.nextLine().split(" ");
                    System.out.print("Salida generada: ");
                    StringBuilder sol = new StringBuilder();///
                                        
                    for (String simbolo : cadena) {
                        // String salidaFSM = Estado.funcion(simbolo);
                        sol.append(Estado.funcion(simbolo));///
                        //System.out.println(sol + " ");///sol
                    }
                    System.out.println(sol + " ");///sol
                    
                    System.out.print("Ingresa el carácter que deseas contar: ");
                    char caracterBuscado = scanner.next().charAt(0);  // Lee el primer carácter ingresado

                    int contador = 0;

                    for (int i = 0; i < sol.length(); i++) {
                        if (sol.charAt(i) == caracterBuscado) {
                            contador++;
                        }
                    }

                    System.out.println("Cantidad de sub-cadenas encontradas: " + contador);

                    break;

                case "7": // Estado actual
                    if (Estado.estadoActual == null) {
                        System.out.println("Estado actual no definido.");
                    } else {
                        System.out.println("Estado actual: #" + listaEstados.indexOf(Estado.estadoActual));
                    }
                    break;

                case "8": // Graficar FSM (placeholder)
                    if (Estado.estados.isEmpty()) {
                        System.out.println("No hay estados creados todavía.");
                    } else {
                        System.out.println("Abriendo ventana con el grafo...");
                        PanelGrafo.mostrar(new ArrayList<>(Estado.estados), Estado.estadoActual);
                    }
                    break;

                case "9": // Salir
                    System.out.println("Saliendo del programa...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        scanner.close();
    }
}







// public class Main {
//     public static void main(String[] args) {
//         Estado estado0 = new Estado();
//         Estado estado1 = new Estado();
//         Estado estado2 = new Estado();
//         Estado estado3 = new Estado();
//         Estado.estadoInicial(estado0);

//         Estado.establecerEntrada(new String[]{"a","b","c"});
//         Estado.establecerSalida(new String[]{"0","1"});

//         estado0.crearF("a", "0", estado0);
//         estado0.crearF("b", "1", estado3);
//         estado0.crearF("c", "1", estado2);

//         estado1.crearF("a", "0", estado1);
//         estado1.crearF("b", "0", estado1);
//         estado1.crearF("c", "1", estado3);

//         estado2.crearF("a", "1", estado1);
//         estado2.crearF("b", "1", estado1);
//         estado2.crearF("c", "0", estado3);

//         estado3.crearF("a", "1", estado2);
//         estado3.crearF("b", "0", estado3);
//         estado3.crearF("c", "1", estado0);

//         String n = "abbccc";

//         StringBuilder sol = new StringBuilder();
//         for (char a : n.toCharArray()){
//             sol.append(Estado.funcion(String.valueOf(a)));
//         }
//         System.out.println(sol);
//     }
// }