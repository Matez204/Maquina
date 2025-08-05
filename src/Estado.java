import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Estado {
    public static HashSet<String> entradas = new HashSet<>();
    public static HashSet<String> salidas = new HashSet<>();
    public static HashSet<Estado> estados = new HashSet<>();
    public static Estado estadoActual;
    public HashMap<String, Estado> fEstado;
    public HashMap<String, String> fSalida;
    public Estado(){
        this.fEstado = new HashMap<>();
        this.fSalida = new HashMap<>();
        estados.add(this);
    }
    public static void establecerEntrada(String[] ent){
        entradas.addAll(Arrays.asList(ent));
    }
    public static void establecerSalida(String[] sal){
        salidas.addAll(Arrays.asList(sal));
    }
    public String crearFSalida(String a, String b){
        if(entradas.contains(a) && salidas.contains(b)){
            this.fSalida.put(a,b);
            return "Arista " + a + ", " + b + " creada";
        }
        return "Simbolos fuera de los alfabetos";
    }
    public String crearFEstado(String a, Estado b){
        if(entradas.contains(a) && estados.contains(b)){
            this.fEstado.put(a,b);
            return "Arista " + a + ", " + b + " creada";
        }
        return "Simbolos o Estado fuera del alfabeto o conjunto";
    }
    public void crearF(String entrada, String salida, Estado nuevoEstado){
        
        if(entradas.contains(entrada) && salidas.contains(salida) && estados.contains(nuevoEstado)){
            this.fSalida.put(entrada,salida);
            this.fEstado.put(entrada,nuevoEstado);
        }
    }
    public static void estadoInicial(Estado a){
        estadoActual = a;
    }
    public static String funcion(String a){
        if (estadoActual == null) return "Estado actual no definido";
        if (!entradas.contains(a)) return "Símbolo fuera del alfabeto";
        if (!estadoActual.fSalida.containsKey(a) || !estadoActual.fEstado.containsKey(a)) {
            return "Transición no definida para la entrada: " + a;
        }

        if(entradas.contains(a)){
            String res = estadoActual.fSalida.get(a);
            estadoActual = estadoActual.fEstado.get(a);
            System.out.println(res);
            return res;
        }
        return "Simbolo fuera del alfabeto";
    }

}
