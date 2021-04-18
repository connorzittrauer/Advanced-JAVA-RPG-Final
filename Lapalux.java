

public class Lapalux extends Character
{
    Lapalux monster;
    Character opponent;
    int health =100, accuracy, attack, physicalDefense, magicalDefense;

    @Override
    public void setHealth()
    {
        health = 100;
    }
    @Override
    public int getHealth()
    {
        return health;
    }
    @Override
    public void kill()
    {
        health = 0;
    }

    @Override
    public void setUsername(String username)
    {
        this.username = username;
    }
    @Override
    public String getUsername()
    {
        return username;
    }

    @Override
    public void setAttack(int value)
    {
        this.attack = value;
    }
    @Override
    public int getAttack()
    {
        return attack;
    }
    @Override
    public void setAccuracy(int value)
    {
        value = rand.nextInt(101);
        this.accuracy = value;
    }
    @Override
    public int getAccuracy()
    {
        return accuracy;
    }
    @Override
    public void setPhysicalDefense(int value)
    {
        this.physicalDefense = value;
    }
    @Override
    public int getPhysicalDefense()
    {
        return physicalDefense;
    }
    @Override
    public void setMagicalDefense(int value)
    {
        this.magicalDefense = value;
    }
    @Override
    public int getMagicalDefense()
    {
        return magicalDefense;
    }

    //----------------------------------------------------------------------
    //attack variable accessor
    @Override
    public void rollDamage()
    {
        attack = attack + rand.nextInt(51);
    }
    @Override
    public void rollAttack()
    {
        accuracy = accuracy + (rand.nextInt(51));
    }
    @Override
    public void rollMagicDefense()
    {

        magicalDefense = magicalDefense + (rand.nextInt(51));

    }
    @Override
    public void rollPhysDefense()
    {
        health = health + physicalDefense;
        physicalDefense = rand.nextInt(25);
        System.out.println("Health Boosted " + physicalDefense + " points!");

    }
    //----------------------------------------------------------------------

    @Override
    public void takeDamage(int damage)
    {

        health = (health - damage);
//        System.out.println("Your Health: " + health + " points");

    }
    @Override
    public void showDamage()
    {
        System.out.println("You inflicted: " + attack + " damage points!");
    }
}