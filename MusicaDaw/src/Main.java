import java.io.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<MusicaDaw> musicaDaws = new LinkedList<>();

        MusicaDaw primerMusicaDaw = null;



        final String pathMusicaDaw = "./src/Resources/";
        final String fileNameMusicaDaw= "MusicaDaw.dat";
        boolean fileModeMusicaDaw = false;
        boolean eof = false;
        boolean isReadingSerializable = false;

        System.out.print("Existe un VideoDaw.dat con datos de uso anteriormente." +
                "\nPresione 1 si desea usar este o presione cualquier otra tecla si desea usar los archivos por defecto en su lugar." +
                "\nEscoja su opcion: ");

        Scanner sc1 = new  Scanner(System.in);

        String input = sc1.nextLine();


        if (input.equalsIgnoreCase("1")){

            try (FileInputStream fileReader = new FileInputStream(pathMusicaDaw+fileNameMusicaDaw);
            ObjectInputStream bufferReader = new ObjectInputStream(fileReader)) {

                while (eof == false){

                    MusicaDaw temp =(MusicaDaw) bufferReader.readObject();
                    musicaDaws.add(temp);
                }

            }catch (EOFException e){
                eof = true;
            }
            catch (IOException e) {
                System.out.println("No se pudo usar el documento en el I/O");
                System.out.println(e.getMessage());

            } catch (InputMismatchException e) {
                System.out.println("Uno de los datos no se pudo leer");
                System.out.println(e.getMessage());
            }catch (Exception e) {
                System.out.println("Algo fue mal");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }


        }else{
            System.out.println("Bienvenido a musicaDaw");

            System.out.println("Inserte el nombre");
            String nombre1MusicaDaw = sc.nextLine();

            System.out.println("Inserte el id");
            String id1MusicaDawString = sc.nextLine();


            primerMusicaDaw = new MusicaDaw(nombre1MusicaDaw,id1MusicaDawString);
            musicaDaws.add(primerMusicaDaw);

            System.out.println(primerMusicaDaw);

        }

        primerMusicaDaw = musicaDaws.get(0);



        String opcion = "";

        do {

            sc = new Scanner(System.in);
            System.out.println("1. Crear otro MusicaDaw");
            System.out.println("2. Registrar Articulo");
            System.out.println("3. ver info de todos los MusicaDaw");
            System.out.println("4. ver info de todos los articulos");
            System.out.println("5. ver info de un MusicaDaw por id");
            System.out.println("6. Ver info de un articulo por id");
            System.out.println("7 Guardar datos");
            System.out.println("8. Salir");
            opcion = sc.nextLine();


            switch (opcion){

                case "1":
                    System.out.println("Inserte el nombre");
                    String nombreMusicaDaw = sc.nextLine();

                    System.out.println("Inserte el id");
                    String idMusicaDawString = sc.nextLine();


                    MusicaDaw nuevoMusicaDaw = new MusicaDaw(nombreMusicaDaw,idMusicaDawString);
                    musicaDaws.add(nuevoMusicaDaw);

                    System.out.println(nuevoMusicaDaw);


                    break;

                case "2":
                    System.out.println("Inserte el id del MusicaDaw en el que quieres insertar el articulo");

                    System.out.println(musicaDaws);

                    String idMusicaDawProducto = sc.nextLine();


                    MusicaDaw tienda = buscarMusicaDawPorId(musicaDaws,idMusicaDawProducto);

                    if (tienda!= null){

                        System.out.println("¿Qué tipo de Producto desea registrar?");
                        System.out.println("1. Vinilo");
                        System.out.println("2. Cd");
                        String tipo = sc.nextLine();

                        switch (tipo){

                            case "1":
                                System.out.println("Inserta el nonbre");

                                String nombreVinilo = sc.nextLine();

                                System.out.println("Inserta Calidad");

                                String calidadVinilo = sc.nextLine();

                                Vinilo nuevoVinilo = new Vinilo(nombreVinilo,calidadVinilo);

                                tienda.addProducto(nuevoVinilo);

                                break;


                            case "2":

                                break;
                        }


                    }else{
                        System.out.println("No exsiste una tienda con ese ID");
                    }

                    break;

                case "3":

                    System.out.println(musicaDaws);

                    break;


                case "5":

                    System.out.println("Inserte el id");
                    String idMusicaDawBuscar = sc.nextLine();

                    for (MusicaDaw musicaDaw : musicaDaws){
                        if (musicaDaw.getId().equalsIgnoreCase(idMusicaDawBuscar)){
                            System.out.println(musicaDaw);
                        }
                    }

                    break;


                case "7":

                    try (FileOutputStream file = new FileOutputStream(pathMusicaDaw+fileNameMusicaDaw,fileModeMusicaDaw);
                         ObjectOutputStream buffer = new ObjectOutputStream(file)){

                        for (MusicaDaw musicaDaw : musicaDaws){
                            buffer.writeObject(musicaDaw);
                        }
                        System.out.println("Se guardaron correctamente");

                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }

                    break;
            }
        }while (!opcion.equals("8"));

    }

    public static MusicaDaw buscarMusicaDawPorId(List<MusicaDaw> lista, String id){

        for (MusicaDaw m : lista){
            if (m.getId().equalsIgnoreCase(id)){
                return m;
            }
        }

        return null;
    }

}