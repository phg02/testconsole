import controller.impl.*;

import util.FileHandler;
import viewer.ConsoleUI;

import controller.impl.TenantManagerImpl;

public class src {
    public static void main(String[] args) {
        ConsoleUI console = new ConsoleUI();
        console.run();

        FileHandler fileHandler = new FileHandler();

        TenantManagerImpl tenantManager = new TenantManagerImpl(fileHandler);

        OwnerManagerImpl ownerManager = new OwnerManagerImpl(fileHandler);

        HostManagerImpl hostManager = new HostManagerImpl(fileHandler);


        CommercialPropertyManagerImpl commercialPropertyManager = new CommercialPropertyManagerImpl(fileHandler);

        ResidentialPropertyManagerImpl residentialPropertyManager = new ResidentialPropertyManagerImpl(fileHandler);

        RentalManagerImpl rentalManager = new RentalManagerImpl(fileHandler);

        PaymentManagerImpl paymentManager = new PaymentManagerImpl(fileHandler);

//        rentalManager.getAllRentalAgreements().forEach(rentalAgreement -> System.out.println(rentalAgreement.getSubTenant()));
        ownerManager.getAllOwners().forEach(owner -> System.out.println(owner.getProperties()));
        tenantManager.getAllTenants().forEach(tenant -> System.out.println(tenant.getPayments()));
    }
}
