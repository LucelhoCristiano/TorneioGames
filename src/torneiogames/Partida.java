package torneiogames;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Bianca Mayra - 322124358
 *                 Lucelho Cristiano - 32218540
 *                 Pedro Frois - 3221174452124358
 */
public class Partida {
    
    SimpleDateFormat formatoDataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    public Date horaInicio;
    public int pontos;
    public boolean vencedor;

    public Partida(Date horaInicio, int pontos) {
        this.horaInicio = horaInicio;
        this.pontos = pontos;
    }        
    
}
