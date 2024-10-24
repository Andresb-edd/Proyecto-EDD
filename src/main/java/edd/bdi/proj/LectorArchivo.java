package edd.bdi.proj;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Clase que se encarga de leer archivos JSON y cargar la información en la aplicación.
 */
public class LectorArchivo {

    /**
     * Lee un archivo JSON y carga la información en la aplicación.
     *
     * @param filePath la ruta del archivo JSON a leer.
     * @param app la instancia de la aplicación donde se cargará la información.
     * @return la instancia de la aplicación con la información cargada.
     * @throws IOException si ocurre un error al leer el archivo.
     */
    public static App leerArchivo(String filePath, App app) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        JsonObject jsonObject = JsonParser.parseString(content).getAsJsonObject();
        String nombreCiudad = new File(filePath).getName().replace(".json", "");
        int idCiudad = app.getSize() + 1;
        Ciudad ciudad = new Ciudad(nombreCiudad, idCiudad);

        for (String red : jsonObject.keySet()) {
            JsonArray lineas = jsonObject.getAsJsonArray(red);
            for (int i = 0; i < lineas.size(); i++) {
                JsonObject lineaObj = lineas.get(i).getAsJsonObject();
                for (String nombreLinea : lineaObj.keySet()) {
                    Linea linea = new Linea(nombreLinea, ciudad.getSize() + 1);
                    JsonArray paradasArray = lineaObj.getAsJsonArray(nombreLinea);
                    for (int j = 0; j < paradasArray.size(); j++) {
                        String nombreParada;
                        if (paradasArray.get(j).isJsonObject()) {
                            JsonObject paradaObj = paradasArray.get(j).getAsJsonObject();
                            String key = paradaObj.keySet().iterator().next();
                            nombreParada = key + ": " + paradaObj.get(key).getAsString();
                        } else {
                            nombreParada = paradasArray.get(j).getAsString();
                        }
                        Parada parada = new Parada(nombreParada, nombreLinea);
                        linea.insert_Parada(parada);
                    }
                    ciudad.insert_Linea(linea);
                }
            }
        }
        app.insert_Ciudad(ciudad);
        return app;
    }

    /**
     * Abre un cuadro de diálogo para seleccionar un archivo y carga la información en la aplicación.
     *
     * @param app la instancia de la aplicación donde se cargará la información.
     * @return la instancia de la aplicación con la información cargada.
     */
    public static App run(App app) {
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File selectedFile = fileChooser.getSelectedFile();
            try {
                app = leerArchivo(selectedFile.getAbsolutePath(), app);
            } catch (java.io.IOException ex) {
                System.out.println("Error al leer el archivo");
            }
        }
        return app;
    }
}