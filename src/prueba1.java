public class prueba1 {
    public static void main(String[] aseraser ){
        Estado estado0 = new Estado();
        Estado estado1 = new Estado();
        Estado estado2 = new Estado();
        Estado estado3 = new Estado();
        Estado.estadoInicial(estado0);
        Estado.establecerEntrada(new String[]{"a","b","c"});
        Estado.establecerSalida(new String[]{"0","1"});
        estado0.crearF("a","0",estado0);
        estado0.crearF("b","1",estado3);
        estado0.crearF("c","1",estado2);
        estado1.crearF("a","0",estado1);
        estado1.crearF("b","0",estado1);
        estado1.crearF("c","1",estado3);
        estado2.crearF("a","1",estado1);
        estado2.crearF("b","1",estado1);
        estado2.crearF("c","0",estado3);
        estado3.crearF("a","1",estado2);
        estado3.crearF("b","0",estado3);
        estado3.crearF("c","1",estado0);

        String n = "abbccc";
        StringBuilder sol = new StringBuilder();
        for (char a : n.toCharArray()){
            sol.append(Estado.funcion(String.valueOf(a)));
        }
        System.out.println(sol);

    }
}
