import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

public class Reembolso {
    public Reembolso() {
    }
    
    public DCBindingContainer getDCBindingsContainer(){
        DCBindingContainer bindingsContainer = 
    (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        
        return bindingsContainer;
    }

    public void calcularReembolsoGeneral(ActionEvent actionEvent) {
        DCBindingContainer bindings = this.getDCBindingsContainer();
        DCIteratorBinding itorBinding = bindings.findIteratorBinding("PasajerosPorPNR1Iterator");
        ViewObject vo = itorBinding.getViewObject();
        Row[] selectRolesRows = vo.getFilteredRows("Seleccionar", true);
        
        int suma = 0;
        System.out.println("Tickets seleccionados: " +selectRolesRows.length);
        for(Row row : selectRolesRows){
            suma = suma +  Integer.parseInt(row.getAttribute("Costo").toString());
            System.out.println("Ticket:" + row.getAttribute("TktEmitido") + " Costo: " + row.getAttribute("Costo"));             
        }
        System.out.println("Costo total:" + suma); 
    }
}
