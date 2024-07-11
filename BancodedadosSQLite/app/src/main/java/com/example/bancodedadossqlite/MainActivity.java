package com.example.bancodedadossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            //criar banco de dados
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);
            //criar tabela
            //bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");
            //bancoDados.execSQL("DROP TABLE pessoas");
            //inserir dados
            //bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Mario', 40)");
            //bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Pedro', 50)");
            //atualizar dados
            //bancoDados.execSQL("UPDATE pessoas SET idade = 19, nome = 'Mariana Silva' WHERE id = 3 ");
            //deletar dados
            //bancoDados.execSQL("DELETE FROM pessoas WHERE id = 3");
            //bancoDados.execSQL("DELETE FROM pessoas");
            //recuperar pessoas
            /*String consulta =   "SELECT nome, idade FROM pessoas " +
                                "WHERE nome = 'Jamilton' AND idade = 30";*/
            /*String consulta =   "SELECT nome, idade FROM pessoas " +
                                "WHERE idade >= 35 OR idade = 18";*/
            /*String consulta =   "SELECT nome, idade FROM pessoas " +
                                "WHERE idade IN(40, 89)";*/
            /*String consulta =   "SELECT nome, idade FROM pessoas " +
                    "WHERE idade BETWEEN 30 AND 35";*/
            /*String filtro = "mar";
            String consulta =   "SELECT nome, idade FROM pessoas " +
                    "WHERE nome LIKE '%" + filtro +"%'";*/
            String consulta =   "SELECT * FROM pessoas " +
                    "WHERE 1=1";

            Cursor cursor = bancoDados.rawQuery(consulta, null);
            //indices da tabela
            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");
            cursor.moveToFirst();
            while (cursor != null){
                String id = cursor.getString(indiceId);
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);
                Log.i("Resultado - id ", "ID: " + id + " / Nome: " + nome + " / Idade: "+ idade);
                cursor.moveToNext();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}