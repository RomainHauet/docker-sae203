import java.io.*;
import java.util.Scanner;

public class GenerateurHTML
{
    static String ligne;
    static String message;

    static String[] numero      = new String[1000];
    static String[] nom         = new String[1000];
    static String[] classe      = new String[1000];
    static String[] description = new String[1000];

    public static void main(String[] args) throws Exception
    {
        File doc = new File("../Data/SCP.data");
        Scanner obj = new Scanner(doc);

        int cpt = 0;
        while (obj.hasNextLine())
        {
            ligne = obj.nextLine();

            String mots[] = ligne.split("\\|", -1);
 
            for (int i = 0; i < mots.length; i++)
            {
                switch (i%4)
                {
                    case 0: { numero[cpt]      = mots[i]; break; }
                    case 1: { nom[cpt]         = mots[i]; break; }
                    case 2: { classe[cpt]      = mots[i]; break; }
                    case 3: { description[cpt] = mots[i]; break; }
                }
                
            }
            cpt++;
        }

        message = "<!DOCTYPE html>\n"+
                  "<html>\n"+
                  "\t<head>\n"+
                  "\t\t<title>\n"+
                  "\t\t\taccueil\n"+
                  "\t\t</title>\n"+
                  "\t</head>\n"+
                  "\t<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\" />\n"+
                  "\t<body>\n"+
                  "\t\t<header>\n"+
                  "\t\t\t<h2>Secure Contain Protect DataBase</h2>\n"+
                  "\t\t</header>\n"+
                  "\t\t<nav>\n"+
                  "\t\t<form action=\"\">\n"+
                  "\t\t\t<label for=\"fnum\"> Num interne : </label>\n"+
                  "\t\t\t<input type=\"text\" id=\"fnum\" name=\"fnum\">\n"+
                  "\t\t\t<br>\n"+
                  "\n"+
                  "\t\t\t<label for=\"fnom\"> Nom entité : </label>\n"+
                  "\t\t\t<input type=\"text\" id=\"fnom\" name=\"fnom\">\n"+
                  "\t\t\t<br>\n"+
                  "\n"+
                  "\t\t\t<label for=\"fdesc\"> Description :</label>\n"+
                  "\t\t\t<input type=\"text\" id=\"fnom\" name=\"desc\">\n"+
                  "\t\t\t<br>\n"+
                  "\n"+
                  "\t\t\t<label for=\"fclasse\"> Classe : </label>\n"+
                  "\t\t\t<select name=\"fclasse\" id=\"cars\">\n"+
                  "\t\t\t<option value=\"Sûr\"> Sûr </option>\n"+
                  "\t\t\t<option value=\"Euclide\"> Euclide </option>\n"+
                  "\t\t\t<option value=\"Keter\"> Keter </option>\n"+
                  "\t\t</select>\n"+
                  "\t\t\t<br>\n"+
                  "\n"+
                  "\t\t\t<input type=\"submit\" value=\"Valider\">\n"+
                  "\t\t</form>\n"+
                  "\t</nav>\n"+
                  "\n"+
                  "\t<table>\n";
        for(int nb = 0; nb < cpt; nb++)
        {
            message += "\t\t<tr>\n";

            message += "\t\t\t<td><a href=\"./SCP/"+numero[nb]+".odt\">"+numero[nb]+"</a></td>\n"+
                       "\t\t\t<td>"+nom[nb]+"</td>\n"+
                       "\t\t\t<td>"+classe[nb]+"</td>\n";

            message += "\t\t</tr>\n";

            try
            {
                FileWriter fw = new FileWriter("../SCP/"+numero[nb]+".odt",false);
                fw.write("SCP-"+numero[nb]+"\n\n"+
                        "Classe :"+classe[nb]+"\n\n"+
                        description[nb]);


                fw.close();
            }
            catch(IOException ioe){}
        }
        message += "\t</table>\n"+
                   "\t</body>\n"+
                   "</html>\n";

            try
            {
                FileWriter fw = new FileWriter("../accueil.html",false);
                fw.write(message);
                fw.close();
            }
            catch(IOException ioe){}
    }
}