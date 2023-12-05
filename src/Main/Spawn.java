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

import java.util.Random;



public class Spawn
{
    private Manejador manejador;
    private HUD hud;
    private Juego juego;
    private Random r = new Random();
    
    private EnemigoJefe jefeFinal;
    
    int puntuacionNivel;
    
    public Spawn( Manejador manejador, HUD hud, Juego juego )
    {
        this.manejador = manejador;
        this.hud = hud;
        this.juego = juego;
    }
    
    public void tick()
    {
        puntuacionNivel++;
        
        if( puntuacionNivel >= 500 )
        {
            puntuacionNivel = 0;
            hud.setNivel( hud.getNivel() + 1 );
            
            if( juego.dificultad == 0 )
            {
                switch( hud.getNivel() )
                {
                    case 3:
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        break;
                    case 4:
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        break;
                    case 5:
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        break;
                    case 6:
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        break;
                    case 8:
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        break;
                    case 10:
                        manejador.borrarEnemigos();
                        manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                        break;
                    case 11:
                        manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                        break;
                    case 12:
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        break;
                    case 13:
                        manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                        break;
                    case 15:
                        manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                        break;
                    case 17:
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        break;
                    case 20:
                        manejador.borrarEnemigos();
                        manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                        break;
                    case 21:
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        break;
                    case 22:
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        break;
                    case 23:
                        manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                        break;
                    case 25:
                        manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                        break;
                    case 27:
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        break;
                    case 28:
                        manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                        break;
                    case 30:
                        manejador.borrarEnemigos();
                        manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                        break;
                    case 31:
                        manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                        break;
                    case 33:
                        manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                        break;
                    case 35:
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        break;
                    case 37:
                        manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                        break;
                    case 38:
                        manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                        break;
                    case 40:
                        manejador.borrarEnemigos();
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                        break;
                    case 42:
                        manejador.borrarEnemigos();
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        break;
                    case 44:
                        manejador.borrarEnemigos();
                        manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                        break;
                    case 46:
                        manejador.borrarEnemigos();
                        manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        break;
                    case 48:
                        manejador.borrarEnemigos();
                        manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                        break;
                    case 50:
                        manejador.borrarEnemigos();
                        manejador.agregarObjeto( new EnemigoJefe( ( Juego.ANCHO / 2 ) - 48, -120, ID.EnemyBoss, manejador ) );
                        break;
                    case 54:
                        manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                        break;
                    case 55:
                        manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                        break;
                    case 57:
                        manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                        manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                        break;
                    case 60:
                        manejador.borrarEnemigos();
                        
                        for( int i = 0; i < manejador.objeto.size(); i++ )
                        {
                            ObjetoJuego tempObjeto = manejador.objeto.get( i );

                            if( tempObjeto.id == ID.EnemyBoss )
                                jefeFinal = ( EnemigoJefe ) tempObjeto;
                        }
                        
                        jefeFinal.derrotado = true;
                        break;
                    case 62:
                        HUD.VIDA = 100 + ( hud.limites / 2 );
                        juego.estadoJuego = Juego.ESTADO.Win;
                        puntuacionNivel = 0;
                        manejador.borrarEnemigos();
                        for( int i = 0; i < 15; i++ )
                        {
                            manejador.agregarObjeto( new ParticulaMenu( r.nextInt( Juego.ANCHO ), r.nextInt( Juego.ALTURA ), ID.MenuParticle, manejador ) );
                        }
                        break;
                    default:
                        break;
                }
            } else if( juego.dificultad == 1 )
                {
                    switch( hud.getNivel() )
                    {
                        case 2:
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            break;
                        case 3:
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            break;
                        case 4:
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            break;
                        case 5:
                            manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                            break;
                        case 7:
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            break;
                        case 8:
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            break;
                        case 10:
                            manejador.borrarEnemigos();
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            break;
                        case 11:
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            break;
                        case 12:
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            break;
                        case 13:
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            break;
                        case 15:
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            break;
                        case 18:
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                            break;
                        case 20:
                            manejador.borrarEnemigos();
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            break;
                        case 22:
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            break;
                        case 24:
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            break;
                        case 25:
                            manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                            break;
                        case 26:
                            manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                            break;
                        case 28:
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            break;
                        case 30:
                            manejador.borrarEnemigos();
                            manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                            break;
                        case 31:
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            break;
                        case 32:
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            break;
                        case 34:
                            manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                            break;
                        case 35:
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            break;
                        case 36:
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            break;
                        case 37:
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            break;
                        case 39:
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            break;
                        case 40:
                            manejador.borrarEnemigos();
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            break;
                        case 42:
                            manejador.borrarEnemigos();
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            break;
                        case 43:
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            break;
                        case 44:
                            manejador.borrarEnemigos();
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            break;
                        case 45:
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            break;
                        case 46:
                            manejador.borrarEnemigos();
                            manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                            break;
                        case 47:
                            manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            break;
                        case 48:
                            manejador.borrarEnemigos();
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            break;
                        case 49:
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            break;
                        case 50:
                            manejador.borrarEnemigos();
                            manejador.agregarObjeto( new EnemigoJefe( ( Juego.ANCHO / 2 ) - 48, -120, ID.EnemyBoss, manejador ) );
                            break;
                        case 52:
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoBasico( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.BasicEnemy, manejador ) );
                            break;
                        case 55:
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoDificil( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.HardEnemy, manejador ) );
                            break;
                        case 56:
                            manejador.agregarObjeto( new EnemigoInteligente( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.SmartEnemy, manejador ) );
                            break;
                        case 58:
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            manejador.agregarObjeto( new EnemigoVeloz( r.nextInt( Juego.ANCHO - 50 ), r.nextInt( Juego.ALTURA - 50 ), ID.FastEnemy, manejador ) );
                            break;
                        case 60:
                            manejador.borrarEnemigos();

                            for( int i = 0; i < manejador.objeto.size(); i++ )
                            {
                                ObjetoJuego tempObjeto = manejador.objeto.get( i );

                                if( tempObjeto.id == ID.EnemyBoss )
                                    jefeFinal = ( EnemigoJefe ) tempObjeto;
                            }

                            jefeFinal.derrotado = true;
                            break;
                        case 62:
                            HUD.VIDA = 100 + ( hud.limites / 2 );
                            juego.estadoJuego = Juego.ESTADO.Win;
                            puntuacionNivel = 0;
                            manejador.borrarEnemigos();
                            for( int i = 0; i < 15; i++ )
                            {
                                manejador.agregarObjeto( new ParticulaMenu( r.nextInt( Juego.ANCHO ), r.nextInt( Juego.ALTURA ), ID.MenuParticle, manejador ) );
                            }
                            break;
                        default:
                            break;
                    }
                }
        }
    }
    
}
