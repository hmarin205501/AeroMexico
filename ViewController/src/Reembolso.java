import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

public class Reembolso {
    private String parametroReembolso;
    private String parametroReembolsoRutas;
    
    public Reembolso() {
    }
    
    
    public DCBindingContainer getDCBindingsContainer(){
        DCBindingContainer bindingsContainer =   (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        
        return bindingsContainer;
    }


/*
    public String calcularReembolsoGeneral(ActionEvent actionEvent) {
        DCBindingContainer bindings = this.getDCBindingsContainer();
        DCIteratorBinding itorBinding = bindings.findIteratorBinding("PasajerosPorPNR1Iterator");
        ViewObject vo = itorBinding.getViewObject();
        Row[] selectRolesRows = vo.getFilteredRows("Seleccionar", true);
        
        int suma = 0;
        String textoTickets = "";
        System.out.println("Tickets seleccionados: " +selectRolesRows.length);
        for(Row row : selectRolesRows){
            suma = suma +  Integer.parseInt(row.getAttribute("Costo").toString());
            System.out.println("Ticket:" + row.getAttribute("TktEmitido") + " Costo: " + row.getAttribute("Costo"));             
            textoTickets = textoTickets + "Ticket: " +  row.getAttribute("TktEmitido")  
                                        + " Costo: " +  row.getAttribute("Costo") + "\n";
        }
        System.out.println("Costo total:" + suma); 
        parametroReembolso = textoTickets +  "\nCosto total:" + suma;
        
        //parametroReembolso="Costo total:" + suma;
        return parametroReembolso;
    }
    
    
    public void setparametroReembolso(String parametroReembolso) {
        this.parametroReembolso = parametroReembolso;
    }
*/

    public String getParametroReembolso() {
        
        DCBindingContainer bindings = this.getDCBindingsContainer();
        DCIteratorBinding itorBinding = bindings.findIteratorBinding("PasajerosPorPNR1Iterator");
        ViewObject vo = itorBinding.getViewObject();
        Row[] selectRolesRows = vo.getFilteredRows("Seleccionar", true);
        
        int suma = 0;
        String textoTickets = "";
        System.out.println("Tickets seleccionados: " +selectRolesRows.length);
        for(Row row : selectRolesRows){
            suma = suma +  Integer.parseInt(row.getAttribute("Costo").toString());
            System.out.println("Ticket:" + row.getAttribute("TktEmitido") + " Costo: " + row.getAttribute("Costo"));             
            textoTickets = textoTickets + "<p>Ticket: " +  row.getAttribute("TktEmitido")  
                                        + " Costo: " +  row.getAttribute("Costo") + "</p>";
        }
        System.out.println("Costo total:" + suma); 
        parametroReembolso = textoTickets +  "<p>Costo total:" + suma + "</p>";

        return parametroReembolso;
    }

    public void ValidaCheck(ValueChangeEvent valueChangeEvent) {
       System.out.println("valueChangeEvent: " + valueChangeEvent.getNewValue());
    }

    public void setParametroReembolso(String parametroReembolso) {
        this.parametroReembolso = parametroReembolso;
    }

    public void setParametroReembolsoRutas(String parametroReembolsoRutas) {
        this.parametroReembolsoRutas = parametroReembolsoRutas;
    }

    public String getParametroReembolsoRutas() {
        
        DCBindingContainer bindings = this.getDCBindingsContainer();
        DCIteratorBinding itorBinding = bindings.findIteratorBinding("DetalleItinerario2Iterator");
        ViewObject vo = itorBinding.getViewObject();
        Row[] selectRolesRows = vo.getFilteredRows("Seleccionar", true);
        
        int suma = 0;
        String textoRutas = "";
        System.out.println("Rutas seleccionadas: " +selectRolesRows.length);
        for(Row row : selectRolesRows){
            System.out.println("Orden " +row.getAttribute("Orden").toString());             
            System.out.println("SolRutaId " + row.getAttribute("SolRutaId").toString());
            System.out.println("Origen " + row.getAttribute("Origen").toString());
            System.out.println("Precio " + row.getAttribute("Precio").toString());
            //System.out.println("Costo " + row.getAttribute("Costo").toString());
           
            suma = suma +  Integer.parseInt(row.getAttribute("Precio").toString());
            textoRutas = textoRutas + "<p>Ruta: " +  row.getAttribute("SolRutaId")  
                                        + " Precio: " +  row.getAttribute("Precio") + "</p>";
            
            
        }
        System.out.println("Costo total:" + suma); 
        parametroReembolsoRutas = textoRutas +  "<p>Costo total:" + suma + "</p>";

        
        return parametroReembolsoRutas;
    }
}
