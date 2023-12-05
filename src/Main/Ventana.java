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


import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;


public class Ventana extends Canvas
{
    private static final long serialVersionUID = -240840600533728354L;
    
    
    public Ventana( int ancho, int altura, String titulo, Juego juego )
    {
        JFrame marco = new JFrame( titulo );
        
        
        marco.setPreferredSize( new Dimension( ancho, altura ) );
        marco.setMaximumSize( new Dimension( ancho, altura ) );
        marco.setMinimumSize( new Dimension( ancho, altura ) );
        
        
        marco.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        marco.setResizable( false );
        marco.setLocationRelativeTo( null );
        marco.add( juego );
        marco.setVisible( true );
        juego.iniciar();
    }
}
