/*
            **************** 
           ****** WAVE ******
            ****************
  [ESPAÑOL]
       ( Versión de PauloCodifica )
  Creado originalmente por RealTutsGML.
  Por favor no redistribuyas este juego sin mi permiso.
  ¡Puedes descargarlo totalmente gratis desde mi repositorio de GitHub!
  Para más información sobre mis juegos o si quieres aprender programación,
  visita mi página web: https://paulocodifica.github.io/
  [ENGLISH]
       ( PauloCodifica's Version )
  Originally created by RealTutsGML.
  Please do not redistribute this game without my permission.
  You can download it totally free from my GitHub repository!
  For more information about my games or if you want to learn about programming,
  visit my website: https://paulocodifica.github.io/
*/

package Main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;


public class Manejador
{
    ArrayList< ObjetoJuego > objeto = new ArrayList< ObjetoJuego >();
    
    public int velocidad = 5;
    
    public void tick()
    {
        for( int i = 0; i < objeto.size(); i++ )
        {
            ObjetoJuego tempObjeto = objeto.get( i );
            
            tempObjeto.tick();
        }
    }
    
    public void render( Graphics g )
    {
        for( int i = 0; i < objeto.size(); i++ )
        {
            ObjetoJuego tempObjeto = objeto.get( i );
            
            tempObjeto.render( g );
        }
        
        /*for( int i = 0; i < objeto.size(); i++ )
        {
            ObjetoJuego tempObjeto = objeto.get( i );
            
            if( tempObjeto.getID() == ID.Player )
                tempObjeto.render( g );
        }*/
    }
    
    public void borrarEnemigos()
    {
        for( int i = 0; i < objeto.size(); i++ )
        {
            ObjetoJuego tempObjeto = objeto.get( i );
            
            if( Juego.estadoJuego != Juego.ESTADO.End && Juego.estadoJuego != Juego.ESTADO.Win )
            {
                if( tempObjeto.getID() != ID.Player && tempObjeto.getID() != ID.EnemyBoss )
                {
                    borrarObjeto( tempObjeto );
                    i--;
                }
            } else
                {
                    borrarObjeto( tempObjeto );
                    i--;
                }
            
        }
    }
    
    public void agregarObjeto( ObjetoJuego objeto )
    {
        this.objeto.add( objeto );
    }
    
    public void borrarObjeto( ObjetoJuego objeto )
    {
        this.objeto.remove( objeto );
    }
}
