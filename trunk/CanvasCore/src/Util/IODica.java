/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rosana
 */
public class IODica {
    
    private static Map<Integer, String> dicas;
        
    public static String getText(int pergunta) throws IOException{
        if(dicas == null){
            lerArquivo();
        }
        return dicas.get(pergunta);
    }
    
    private static void lerArquivo() throws FileNotFoundException, IOException{
        dicas = new HashMap();
        FileReader fileReader = new FileReader(Constantes.ADDRESS_DICA);
        BufferedReader reader = new BufferedReader(fileReader);
        String data = null;
        while ((data = reader.readLine()) != null) {
            String linha[] = data.split(Constantes.SEPARADOR);
            dicas.put(Integer.parseInt(linha[Constantes.POS_ID]), linha[Constantes.POS_DICA]);
        }
        fileReader.close();
        reader.close();
        
    }
            
    
}
