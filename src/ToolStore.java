public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }
    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya Hoşgeldiniz !");
        boolean showmenu = true;
        while (showmenu) {
            System.out.println("1- Silahlar");
            System.out.println("2- Zırh");
            System.out.println("3- Çıkış");
            System.out.print("Seçiminiz");
            int selectCase = Location.input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Geçersiz değer, tekrar giriniz: ");
                selectCase = input.nextInt();
            }
            switch (selectCase) {

                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz");
                    showmenu = false;
                    break;

            }

        }
        return true;
    }
    public void printWeapon(){

        System.out.println("-------------Silahlar---------------");
        System.out.println();
        for(Weapon w:Weapon.weapons()){
            System.out.println(w.getName() + " <Para : "+ w.getPrice()+" , Hasar : "+ w.getDamage()+" >");
        }
        System.out.println("0 -Çıkışyap");

    }
    public void buyWeapon(){
        System.out.println("Bir Silah seçiniz : ");
        int selectWeaponID = input.nextInt();
        while(selectWeaponID<0 || selectWeaponID > Weapon.weapons().length){
            System.out.println("Geçersiz Değer, tekrar giriniz: ");
            selectWeaponID=input.nextInt();
        }
        if(selectWeaponID!=0) {
            Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponID);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır !");
                } else {
                    System.out.println(selectedWeapon.getName() + " silahını satın aldınız !");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                    System.out.println("Önceki silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Şimdiki silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }
    }
    public void printArmor(){

        System.out.println("---------------Zırhlar-----------");
        for(Armor a:Armor.armors()){
            System.out.println(a.getId()+" -  "+ a.getName()+
                    "<Para :  "+a.getPrice()+ ", Zırh : "+a.getBlock()+" >");
        }
        System.out.println("0 -Çıkışyap");
    }
    public void buyArmor(){
        System.out.println("Bir Zırh seçiniz : ");
        int selectArmorID = input.nextInt();
        while(selectArmorID<1 || selectArmorID > Armor.armors().length){
            System.out.println("Geçersiz Değer, tekrar giriniz: ");
            selectArmorID=input.nextInt();
        }
        if(selectArmorID!=0) {
            Armor selectedArmor = Armor.getArmorObjById(selectArmorID);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır !");
                } else {
                    System.out.println(selectedArmor.getName() + " zırhını satın aldınız !");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                    System.out.println("Önceki zırhınız: " + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Şimdiki zırhınız: " + this.getPlayer().getInventory().getArmor().getName());
                }
            }
        }
    }
}
