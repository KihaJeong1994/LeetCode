class ParkingSystem {
    private final int[] availableSpace;

    public ParkingSystem(int big, int medium, int small) {
        availableSpace = new int[]{0,big,medium,small};
    }
    
    public boolean addCar(int carType) {
        if(availableSpace[carType]>0){
            availableSpace[carType] -= 1;
            return true;
        }else{
            return false;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */