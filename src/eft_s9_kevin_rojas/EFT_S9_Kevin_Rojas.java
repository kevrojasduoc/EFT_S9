package eft_s9_kevin_rojas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Kevin Rojas
 */
public class EFT_S9_Kevin_Rojas {
    static Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    static ArrayList<String> clientesInfo = new ArrayList<>();
    static boolean[] asientosTeatro = new boolean[10];
    static ArrayList<String> entradasTeatro = new ArrayList<>();
    static String[][] promosTeatro = new String[10][2];
    static ArrayList<String> eventosTeatro = new ArrayList<>();
    static boolean validarAsiento = false;
    static int ubicacionAsiento;
    static int seleccionEvento;
    static String entradaTipoBoleta = "";
    static double entradaCostoBase = 0;
    static int totalEntradasVendidas = 0;
    
    public static void main(String[] args) {
        boolean salir = false;
        Arrays.fill(asientosTeatro, true);
        promosTeatro[0][0] = "Promo Estudiante";
        promosTeatro[0][1] = "10";
        promosTeatro[1][0] = "Promo Tercera Edad";
        promosTeatro[1][1] = "15";
        eventosTeatro.add("Teatro: Hamlet William Shakespeare");
        eventosTeatro.add("Concierto: Orquesta Filarmonica de Viena");
                                   
        do{
            try{
                System.out.println("""
                                [1] Menu Ventas
                                [2] Menu Clientes
                                [3] Menu Promos 
                                [4] Menu Eventos
                                [0] Salir del sistema
                                Ingresar opcion:""");
                int opmenu = scanner.nextInt();
                switch(opmenu){
                    case 1->{
                        System.out.println("""
                                           [1] Ingresar venta
                                           [2] Ver ventas
                                           [3] Modificar una venta
                                           [4] Eliminar una venta
                                           [0] Volver atras
                                           """);
                        int subMenuVentaOp = scanner.nextInt();
                        if (subMenuVentaOp == 1){
                            ingresarVentas();
                        }else if(subMenuVentaOp == 2){
                            totalEntradasTeatro();
                        }else if(subMenuVentaOp == 3){
                            System.out.println("Ingrese el ID del cliente: ");
                            int idCliente = scanner.nextInt();
                            modificarVenta(idCliente);
                        }else if (subMenuVentaOp == 4){
                            System.out.println("Ingrese el ID del cliente: ");
                            int idCliente = scanner.nextInt();
                            eliminarClientesVentas(idCliente);
                        }else if(subMenuVentaOp == 0){
                            break;
                        }
                        else{
                            System.out.println("Ingrese una opcion valida");
                        }                                             
                    }
                    case 2->{
                        System.out.println("""
                                           [1] Ver clientes
                                           [2] Mostrar Cliente por Id
                                           [3] Eliminar Cliente por Id
                                           [0] Volver atras
                                           """);
                        int subMenuVentaOp = scanner.nextInt();
                        if(subMenuVentaOp == 1){
                            mostrarClientes();                           
                        }else if(subMenuVentaOp == 2){
                            System.out.println("Ingresar Id Cliente: ");
                            int idCliente = scanner.nextInt();
                            mostrarClienteBoleta(idCliente);
                        }else if(subMenuVentaOp == 3){
                            System.out.println("Ingresar Id Cliente: ");
                            int idCliente = scanner.nextInt();
                            eliminarClientesVentas(idCliente);
                        }else if(subMenuVentaOp == 0){
                            break;
                        }else{
                            System.out.println("Revise el menu e ingrese un dato valido...");
                        }                     
                    }
                    case 3->{
                        System.out.println("""
                                           [1] Ver promos
                                           [2] Agregar promos
                                           [3] Eliminar promos
                                           [0] Volver atras
                                           """); 
                        int subMenuVentaOp = scanner.nextInt();
                        if(subMenuVentaOp == 1){
                            mostrarPromosTeatro();
                        }else if(subMenuVentaOp == 2){
                            agregarPromosTeatro();
                        }else if(subMenuVentaOp == 3){
                            System.out.println("Ingresar el Id de la promo a borrar: ");
                            int idPromo = scanner.nextInt();
                            eliminarPromosTeatro(idPromo-1);
                        }else if(subMenuVentaOp == 0){
                            break;
                        }else{
                            System.out.println("Revise el menu e ingrese un dato valido...");
                        }
                    }
                    case 4->{
                        System.out.println("""
                                           [1] Ver eventos
                                           [2] Agregar eventos
                                           [3] Modificar eventos
                                           [4] Eliminar Eventos
                                           [0] Volver atras
                                           """); 
                        int subMenuVentaOp = scanner.nextInt();
                        if(subMenuVentaOp == 1){
                            motrarEventos();
                        }else if(subMenuVentaOp == 2){
                            agregarEvento();
                        }else if(subMenuVentaOp == 3){
                            modificarEvento();                          
                        }else if(subMenuVentaOp == 4){
                            System.out.println("Ingrese el id de evento a eliminar ");
                            int idEvento = scanner.nextInt();
                            eliminarEventos(idEvento);
                        }else{
                            System.out.println("Revise el menu e ingrese un dato valido...");
                        }
                    }
                    case 0->{
                        System.out.println("Saliendo del sistema...");
                        salir = true;
                    }
                }              
            }catch(Exception e){
                System.out.println("ERROR DE INGRESO, REVISE LOS DATOS INGRESADOS!");
                scanner.next();
            }    
        }while(!salir);       
    }//end main
    
    public static void agregarEvento(){
        scanner.nextLine();
        
        String tipoConcierto = "Concierto: ";
        String tipoTeatro = "Teatro: ";
        String eventoFinal = null;
        System.out.println("Ingrese el tipo de evento[1] Concierto - [2] Teatro]: ");
        int tipoEvento = scanner.nextInt();
        if(tipoEvento == 1){
           eventoFinal = tipoConcierto;
        }else if(tipoEvento == 2){
            eventoFinal = tipoTeatro;
        }else{
            System.out.println("Ingrese una opcion valida para el evento!");
        }
        scanner.nextLine();
        System.out.println("Ingrese el nombre del evento[Ejemplo: Iron Maiden - El Fantasma de la Opera] : ");
        String nombreEvento = scanner.nextLine();
        String ingresarEvento = eventoFinal + nombreEvento;
        eventosTeatro.add(ingresarEvento);
        System.out.println("Evento ingresado correctamente!");
    }
    
    public static void modificarEvento(){
        System.out.println("Modificar Evento - ingresar Id");
        int idEvento = scanner.nextInt();
        eventosTeatro.get(idEvento-1);
        System.out.println(eventosTeatro.get(idEvento-1));
        String tipoConcierto = "Concierto: ";
        String tipoTeatro = "Teatro: ";
        String eventoFinal = null;
        System.out.println("Ingrese el tipo de evento[1] Concierto - [2] Teatro]: ");
        int tipoEvento = scanner.nextInt();
        if(tipoEvento == 1){
           eventoFinal = tipoConcierto;
        }else if(tipoEvento == 2){
            eventoFinal = tipoTeatro;
        }else{
            System.out.println("Ingrese una opcion valida para el evento!");
        }
        scanner.nextLine();
        System.out.println("Ingrese el nombre del evento[Ejemplo: Iron Maiden - El Fantasma de la Opera] : ");
        String nombreEvento = scanner.nextLine();
        String ingresarEvento = eventoFinal + nombreEvento;
        eventosTeatro.set(idEvento-1, ingresarEvento);
        System.out.println("Evento ingresado correctamente!"); 
    }
    
    public static void motrarEventos(){
        for (int i = 0; i < eventosTeatro.size(); i++) {
            String eventos = eventosTeatro.get(i);
            System.out.println("ID: " + (i+1)+"\n"+eventos);
        }
    }
    
    public static void eliminarEventos(int idEvento){
        eventosTeatro.remove(idEvento-1);
        System.out.println("Evento eliminado!");
    }
      
    public static void ingresarClientes(){
        String nombreCliente = null;
        String apellidoCliente = null;
        int edadCliente = 0;
        String rutCliente = null;
        boolean validarRut = false;
        boolean validarNombre = false;
        boolean validarApellido = false;
        boolean validarEdad = false;
        System.out.println("##### SOLICITAR DATOS CLIENTE #####"); 
        scanner.nextLine();
        while(!validarRut){          
            System.out.println("Ingrese su RUT (con digito verificador anteponiendo un guion):"
                    + "Formatos Admitidos: XX.XXX.XXX-X | XXXXXXXX-X");
            rutCliente = scanner.nextLine();
            if (rutCliente.matches("\\b\\d{1,2}\\.?\\d{3}\\.?\\d{3}-\\d{1}")) {
                System.out.println("El RUT ingresado es valido.");  
                validarRut=true;
            } else {
                System.out.println("El RUT ingresado no es valido.");   
            }
        }
        
        while(!validarNombre){
            System.out.println("Ingrese el nombre del cliente: ");
            nombreCliente = scanner.nextLine();
            if(nombreCliente.matches("[a-zA-Z]+")){
                System.out.println("Nombre ingreado es valido");
                validarNombre = true;
            }else{
                System.out.println("Ingrese un nombre valido.");
            }
        }
        
        while(!validarApellido){
            System.out.println("Ingrese el apellido del cliente: ");
            apellidoCliente = scanner.nextLine();
            if(apellidoCliente.matches("[a-zA-Z]+")){
                System.out.println("Apellido ingreado es valido");
                validarApellido = true;
            }else{
                System.out.println("Ingrese un apellido valido.");
            }
        }
        
        while(!validarEdad){
            System.out.println("Ingrese la edad del cliente: ");
            edadCliente = scanner.nextInt();
            if (edadCliente >=18){
                System.out.println("Edad ingresada es valida!");
                validarEdad = true;
            }else {
                System.out.println("Ingrese una edad valida o cliente es menor de 18 años");
            }
        }

       clientesInfo.add("Rut Cliente: " + rutCliente+"\n"+"Nombre: "+nombreCliente+"\n"+"Apellido: "+ apellidoCliente+"\n" +"Edad: "+edadCliente);  
    } 
    
    public static void modificarVenta(int idCliente){
        mostrarClienteBoleta(idCliente);
        String clienteInfo = entradasTeatro.get(idCliente-1);
        String[] detalleCliente = clienteInfo.split(":");
        System.out.println("Modificando Ubicacion del Asiento: ");
        mostrarAsientos();
        System.out.println("Ingrese nuevo asiento disponible: ");
        int seleccionAsiento = scanner.nextInt();
        String.valueOf(seleccionAsiento);   
        String asientoNuevo =String.valueOf(seleccionAsiento);
        detalleCliente[4] = asientoNuevo;
        String reemplazarAsiento = String.join(":", detalleCliente);
        entradasTeatro.set(idCliente-1, reemplazarAsiento+"\n");
        System.out.println("Entrada modificada...");   
    }
    
    public static void mostrarClienteBoleta(int idCliente){
        String datosCliente = clientesInfo.get(idCliente-1);
        String datosEntrada = entradasTeatro.get(idCliente-1);
        System.out.println(datosCliente+"\n"+datosEntrada);
    }
    
    public static void eliminarClientesVentas(int idCliente){
        clientesInfo.remove(idCliente-1);
        entradasTeatro.remove(idCliente-1);
        System.out.println("Cliente y Venta eliminada...!");
    }
    
    public static void mostrarClientes(){
        for (int i = 0; i < clientesInfo.size(); i++) {
            String cliente = clientesInfo.get(i);
            System.out.println("ID: " + (i+1)+"\n"+cliente);
        }
    }
    
    public static void mostrarPromosTeatro(){
        System.out.println("Listado de promos:");
        for (int i = 0; i < promosTeatro.length; i++) {
            if (promosTeatro[i][0] != null) {
                System.out.println("ID: [" + (i+1) + "] Nombre: " + promosTeatro[i][0] + ", Descuento: " + promosTeatro[i][1] + "%");
            }
        }
    }
    
    public static void eliminarPromosTeatro(int idPromo){
        if (idPromo >= 0 && idPromo < promosTeatro.length && promosTeatro[idPromo][0] != null) {
            promosTeatro[idPromo][0] = null;
            promosTeatro[idPromo][1] = null;
            System.out.println("Promo borrada correctamente.");
        } else {
            System.out.println("No se encontro la promo con ID " + idPromo + ".");
        }
    }
    
    public static void agregarPromosTeatro(){
        scanner.nextLine();
        System.out.println("Ingrese el nombre de la promo:");
        String nombrePromo = scanner.nextLine();
        
        
        if(!nombrePromo.trim().isEmpty()){
            System.out.println("Ingrese el porcentaje de descuento:");
            String descuentoPromo = scanner.nextLine();
            if(validarNumero(descuentoPromo)){
                double descuentoValido = Double.parseDouble(descuentoPromo);
                if(descuentoValido >=0 && descuentoValido <=100){
                    for (int i = 0; i < promosTeatro.length; i++) {
                        if (promosTeatro[i][0] == null) {
                            promosTeatro[i][0] = nombrePromo;
                            promosTeatro[i][1] = descuentoPromo;
                            System.out.println("Promo creada correctamente.");
                            return;
                        }
                    }
                    System.out.println("No se pudo crear la promo. Elimine promociones antes de crear una nueva.");
                }else{
                    System.out.println("Porcentaje debe estar entre 0 a 100");
                }
            }else{
                System.out.println("Ingrese un numero valido de descuento!");
            }
        }else{
            System.out.println("Ingrese un nombre de la promocion no puede estar vacio");
        }  
    }
    
    public static boolean validarNumero(String str){
        try {
            Double.valueOf(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static void validarVenta(int tipoPromo, int seleccionAsiento, int tipoEntrada){     
        String boleta = null;
        double precios = 0;

        switch (tipoEntrada)
        {
            case 1 ->
            {
                boleta = "VIP";
                precios = 20000;
            }
            case 2 ->
            {
                boleta = "PLATEA";
                precios = 15000;
            }
            case 3 ->
            {
                boleta = "GENERAL";
                precios = 10000;
            }
            default -> System.out.println("tipo de entrada invalido");
        }
        
        if (tipoPromo >= 0 && tipoPromo < promosTeatro.length) {
            String[] promoSeleccionada = promosTeatro[tipoPromo];
            if (promoSeleccionada[0] != null && promoSeleccionada[1] != null) {
                String nombrePromo = promoSeleccionada[0];
                double porcentajeDescuento = Double.parseDouble(promoSeleccionada[1]);
                double descuento = 1 - (porcentajeDescuento / 100);
                double finalPrecio = precios * descuento;                            
                entradaTipoBoleta = boleta;                  
                entradaCostoBase = precios;               
                asientosTeatro[seleccionAsiento - 1] = false;
                System.out.println("#####################################");
                System.out.println("       BOLETA TEATRO MORO            ");
                System.out.println("#####################################");
                System.out.println("Detalle:");
                System.out.println("Entrada: " + boleta);
                System.out.println("Evento: " + (eventosTeatro.get(seleccionEvento-1)));
                System.out.println("Descuento: " + nombrePromo + " "+ porcentajeDescuento+"%");
                System.out.println("Asiento:" + ubicacionAsiento);
                System.out.println("Total a pagar: " + finalPrecio);
                System.out.println("#####################################");
                String descuentoAplicado = ("Descuento: " + nombrePromo + " "+ porcentajeDescuento+"%");
                entradasTeatro.add("Tipo Evento: "+ (eventosTeatro.get(seleccionEvento-1))+"\n"+"Tipo de Entrada: "+entradaTipoBoleta+"\n"+"Costo Base: "+entradaCostoBase+"\n"+"Descuento Aplicado: "+descuentoAplicado+"\n"+"Ubicacion: "+ubicacionAsiento+"\n"+"Costo Final: "+ finalPrecio);               
            } else {             
                System.out.println("La entrada seleccionada no está definida.");
            }
        }else{
                System.out.println("El índice seleccionado está fuera de los límites del array.");
        }   
    }    

    public static void ingresarVentas(){ 
        //scanner.nextLine();
        boolean ingresoOk = false;
        while(!ingresoOk){
            System.out.println("#### SELECCION DE EVENTO ####");
            motrarEventos();
            System.out.println("Ingrese el evento deseado por Id: ");
            seleccionEvento = scanner.nextInt();

            scanner.nextLine();
            System.out.println("""
                               ##### SELECCION DE ENTRADAS #####
                               [1]-VIP
                               [2]-PLATEA
                               [3]-GENERAL
                               """);
            System.out.println("Ingresar entrada deseada: ");
            int tipoEntrada = scanner.nextInt();
            scanner.nextLine();
            if(tipoEntrada == 1 || tipoEntrada == 2 || tipoEntrada == 3){
                    mostrarPromosTeatro();
                    System.out.println("Ingresar promocion deseada: ");
                    int tipoPromo = scanner.nextInt();
                    mostrarAsientos();
                    System.out.println("Seleccionar Asiento: ");
                    int seleccionAsiento = scanner.nextInt();
                    validarAsientos(seleccionAsiento);
                    ingresarClientes();
                    if ((validarAsiento == true) && tipoEntrada == 1 || tipoEntrada == 2 || tipoEntrada ==3){
                        validarVenta(tipoPromo-1, seleccionAsiento, tipoEntrada);
                    }else{
                        System.out.println("Revisar las opciones elegidas..!");
                    }
            }else{
                System.out.println("Ingrese una opcion valida!");
            }     
        }    
    }

    public static void totalEntradasTeatro(){
        System.out.println("Resumen de boletas");
        System.out.println("#########################################");
        for (int i=0; i< entradasTeatro.size();i++){
            System.out.println("ID: "+(i + 1)+"\n" + " " + entradasTeatro.get(i));
            System.out.println("#########################################");
        }
        totalEntradasVendidas = entradasTeatro.size();
        System.out.println("Total de boletas: " + totalEntradasVendidas);
    }
    
    public static void mostrarAsientos(){
        System.out.println("##### ASIENTOS DEL TEATRO #####");
        for(int c = 0; c < asientosTeatro.length; c++){                                     
            if(asientosTeatro[c]){
                System.out.println("Asiento: " + (c + 1) + ": Disponible");
            }else{
                 System.out.println("Asiento: " + (c + 1) + ": Ocupado");
            }
        }  
    }
    
    public static void validarAsientos(int numAsiento){
        if (asientosTeatro[numAsiento - 1]){
            System.out.println("Asiento: " + numAsiento + " Se encuentra Disponible");
            ubicacionAsiento = numAsiento;
            validarAsiento = asientosTeatro[numAsiento - 1];
        }else{
            System.out.println("Asiento: " + numAsiento + " Se encuentra Ocupado");
            validarAsiento = false;
        }
    }

}
