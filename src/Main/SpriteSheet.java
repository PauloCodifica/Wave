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

import java.awt.image.BufferedImage;


public class SpriteSheet
{
    private BufferedImage sprite;
    
    public SpriteSheet( BufferedImage ss )
    {
        this.sprite = ss;
    }
    
    public BufferedImage agarrarImagen( int columna, int fila, int ancho, int altura )
    {
        BufferedImage imagen = sprite.getSubimage( ( fila * 32 ) - 32, ( columna * 32 ) - 32, ancho, altura );
        return imagen;
    }
    
    public BufferedImage agarrarImagen96x96( int columna, int fila, int ancho, int altura )
    {
        BufferedImage imagen = sprite.getSubimage( ( fila * 96 ) - 96, ( columna * 96 ) - 96, ancho, altura );
        return imagen;
    }
}
