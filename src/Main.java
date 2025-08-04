
public class Main {
    public static void main(String[] args) {
        Estado estado0 = new Estado();
        Estado estado1 = new Estado();
        Estado estado2 = new Estado();
        Estado.estadoInicial(estado0);
        Estado.establecerEntrada(new String[]{"0","1"});
        Estado.establecerSalida(new String[]{"0","1"});
        estado0.crearFSalida("0","0");
        estado0.crearFSalida("1","0");
        estado0.crearFEstado("0",estado0);
        estado0.crearFEstado("1",estado1);

        estado1.crearFSalida("0","0");
        estado1.crearFSalida("1","0");
        estado1.crearFEstado("0",estado2);
        estado1.crearFEstado("1",estado1);

        estado2.crearFSalida("0","0");
        estado2.crearFSalida("1","1");
        estado2.crearFEstado("0",estado0);
        estado2.crearFEstado("1",estado1);
        String n = "010101010";
        StringBuilder sol = new StringBuilder();
        for (char a : n.toCharArray()){
            sol.append(Estado.funcion(String.valueOf(a)));
        }
        System.out.println(sol);
    }
}