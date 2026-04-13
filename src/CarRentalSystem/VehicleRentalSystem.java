package CarRentalSystem;

import java.util.List;

public class VehicleRentalSystem {
    List<Store>  stores;
    List<User> users;

    public VehicleRentalSystem(List<Store> stores, List<User> users) {
        this.stores = stores;
        this.users = users;
    }

    public Store getStore(int storeId){
        return stores.stream().filter(store->store.getStoreID()==storeId).findFirst().get();
    }

    public User getUser(int userId){
        return users.stream().filter(user->user.getUserId()==userId).findFirst().get();
    }

    public void  addStore(Store store){
        stores.add(store);
    }
    public void addUser(User user){
        users.add(user);
    }

    public void removeStore(Store store){
        stores.remove(store);
    }

    public void removeUser(User user){
        users.remove(user);
    }
}
