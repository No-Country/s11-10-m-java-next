import java.time.LocalDate;

import com.reparame.demo.enumeradores.ProgresoTicket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketClienteDTO {
    private Long id;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaRequerida;
    private ProgresoTicket progreso;
    private PrestadorServicioListadoDTO prestador;
}
