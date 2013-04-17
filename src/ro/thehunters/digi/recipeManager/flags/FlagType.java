package ro.thehunters.digi.recipeManager.flags;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

import ro.thehunters.digi.recipeManager.Messages;
import ro.thehunters.digi.recipeManager.Permissions;

public enum FlagType
{
    // TODO go through each flag and check:
    // new Flag(this) clone style and must have this() in them !!!!!
    // protected on*() methods
    // ...
    
//    TEST(FlagTest.class, Bit.NO_VALUE), // TODO remove
    
    // Shared flags
    COMMAND(FlagCommand.class, Bit.NONE, "cmd", "commands"),
    KEEPITEM(FlagKeepItem.class, Bit.NO_SHIFT, "returnitem", "replaceitem"),
    INGREDIENTCONDITION(FlagIngredientCondition.class, Bit.NO_SHIFT, "ingrcondition", "ingrcond", "ifingredient", "ifingr"), // TODO finish
    PERMISSION(FlagPermission.class, Bit.NONE, "permissions", "perm"),
    FORPERMISSION(FlagForPermission.class, Bit.NO_SHIFT, "forperm"),
    FORCHANCE(FlagForChance.class, Bit.NO_SHIFT),
    GROUP(FlagGroup.class, Bit.NONE, "groups", "permissiongroup"),
    WORLD(FlagWorld.class, Bit.NONE, "needworld", "worlds"), // TODO redesign required
    NEEDHEIGHT(FlagNeedHeight.class, Bit.NONE, "height"), // TODO finish
    MODEXP(FlagModExp.class, Bit.NO_SHIFT, "expmod", "modxp", "xpmod", "exp", "xp", "giveexp", "givexp", "takeexp", "takexp"),
    NEEDEXP(FlagNeedExp.class, Bit.NONE, "needxp", "reqexp", "expreq", "reqxp", "xpreq"),
    MODLEVEL(FlagModLevel.class, Bit.NO_SHIFT, "levelmod", "setlevel", "level"),
    NEEDLEVEL(FlagNeedLevel.class, Bit.NONE, "reqlevel", "levelreq"),
    MODMONEY(FlagModMoney.class, Bit.NO_SHIFT, "moneymod", "setmoney", "money"),
    NEEDMONEY(FlagNeedMoney.class, Bit.NONE, "reqmoney", "moneyreq"),
    COOLDOWN(FlagCooldown.class, Bit.NO_SHIFT, "cooltime", "delay"),
    REALTIME(FlagRealTime.class, Bit.NONE, "time", "date"),
    ONLINETIME(FlagOnlineTime.class, Bit.NONE),
    HOLDITEM(FlagHoldItem.class, Bit.NONE, "hold"),
    GAMEMODE(FlagGameMode.class, Bit.NONE, "needgm"),
    LIGHTLEVEL(FlagLightLevel.class, Bit.NONE, "blocklight", "sunlight", "light"),
    BIOME(FlagBiome.class, Bit.NONE), // TODO finish
    WEATHER(FlagWeather.class, Bit.NONE), // TODO finish
    WORLDTIME(FlagWorldTime.class, Bit.NONE), // TODO finish
    EXPLODE(FlagExplode.class, Bit.NO_SHIFT | Bit.NO_VALUE, "explosion", "boom", "tnt"),
    SOUND(FlagSound.class, Bit.NO_SHIFT, "playsound"),
    SUMMON(FlagSummon.class, Bit.NO_SHIFT, "spawn", "creature", "mob", "animal"),
    BLOCKPOWERED(FlagBlockPowered.class, Bit.NO_VALUE, "poweredblock", "blockpower", "redstonepowered"),
    POTIONEFFECT(FlagPotionEffect.class, Bit.NONE, "potionfx"),
    LAUNCHFIREWORK(FlagLaunchFirework.class, Bit.NO_SHIFT, "setfirework"),
    TELEPORT(FlagTeleport.class, Bit.NO_SHIFT, "tpto", "goto"),
    MESSAGE(FlagMessage.class, Bit.NONE, "craftmsg"),
    SECRET(FlagSecret.class, Bit.NO_VALUE, "hide"),
    DEBUG(FlagDebug.class, Bit.NO_VALUE, "monitor", "log"),
    
    // Recipe only flags
    DOCUMENTATION(FlagDocumentation.class, Bit.RECIPE | Bit.NO_SKIP_PERMISSION, "doc", "html"), // TODO finish
    RECIPEBOOK(FlagRecipeBook.class, Bit.RECIPE | Bit.NO_SKIP_PERMISSION, "bookrecipe"),
    DESCRIPTION(FlagDescription.class, Bit.RECIPE, "recipeinfo", "info"),
    GETBOOK(FlagGetBook.class, Bit.RECIPE | Bit.NO_SHIFT | Bit.NO_SKIP_PERMISSION, "getrecipebook", "bookresult"), // TODO finsih
    FAILMESSAGE(FlagFailMessage.class, Bit.RECIPE, "failmsg"), // TODO finish
//    HIDERESULTS(FlagHideResults.class, Bit.RECIPE | Bit.NO_VALUE), // TODO finish or remove ?
    REMOVE(FlagRemove.class, Bit.RECIPE | Bit.NO_VALUE | Bit.NO_SKIP_PERMISSION, "delete"),
    RESTRICT(FlagRestrict.class, Bit.RECIPE | Bit.NO_VALUE | Bit.NO_SKIP_PERMISSION, "disable", "denied", "deny"),
    OVERRIDE(FlagOverride.class, Bit.RECIPE | Bit.NO_VALUE | Bit.NO_SKIP_PERMISSION, "edit", "overwrite", "supercede", "replace"),
    PROXIMITY(FlagProximity.class, Bit.RECIPE, "distance", "nearby"), // TODO
    
    // Result only flags    
    // TODO remove NO_STORE bit
    RESULTCHANCE(FlagResultChance.class, Bit.RESULT, "modchance", "setchance"), // TODO finish
    CLONEINGREDIENT(FlagCloneIngredient.class, Bit.RESULT | Bit.NO_SHIFT, "clone", "copy", "copyingredient"), // TODO finish
    ITEMNAME(FlagItemName.class, Bit.RESULT | Bit.NO_STORE, "name", "displayname"),
    ITEMLORE(FlagItemLore.class, Bit.RESULT | Bit.NO_STORE, "lore", "itemdesc"),
    LEATHERCOLOR(FlagLeatherColor.class, Bit.RESULT, "leathercolour", "color", "colour"),
    ITEMBOOK(FlagItemBook.class, Bit.RESULT | Bit.NO_STORE, "bookitem"),
    MAPITEM(FlagMapItem.class, Bit.RESULT | Bit.NO_STORE, "map", "mapitem"),
    FIREWORKITEM(FlagFireworkItem.class, Bit.RESULT | Bit.NO_STORE, "firework", "fireworkrocket"),
    FIREWORKCHARGEITEM(FlagFireworkChargeItem.class, Bit.RESULT | Bit.NO_STORE, "fireworkcharge", "fireworkeffect"),
    SKULLOWNER(FlagSkullOwner.class, Bit.RESULT | Bit.NO_STORE, "skullowner"),
    POTIONITEM(FlagPotionItem.class, Bit.RESULT | Bit.NO_STORE, "potion", "potionitem"),
    ENCHANTITEM(FlagEnchantItem.class, Bit.RESULT | Bit.NO_STORE, "enchant", "enchantment"),
    ENCHANTENGBOOK(FlagEnchantingBook.class, Bit.RESULT | Bit.NO_STORE, "enchantbook", "enchantedbook"),
    
    ;
    
    /*
     *  FlagType related methods
     */
    
    private final Class<? extends Flag> flagClass;
    private final String[] names;
    private final int bits;
    
    private FlagType(Class<? extends Flag> flagClass, int bits, String... aliases)
    {
        this.flagClass = flagClass;
        this.bits = bits;
        
        this.names = new String[aliases.length + 1];
        this.names[0] = name().toLowerCase();
        
        for(int i = 0; i < aliases.length; i++)
        {
            this.names[i + 1] = aliases[i];
        }
    }
    
    /**
     * Checks if flag type has a special bit.
     * 
     * @param bit
     *            See {@link Bit}
     * @return
     */
    public boolean hasBit(int bit)
    {
        return (bits & bit) == bit;
    }
    
    /**
     * @return the class asigned to this type (not the instance)
     */
    public Class<? extends Flag> getFlagClass()
    {
        return flagClass;
    }
    
    /**
     * @return array of flags names, index 0 is always the main name
     */
    public String[] getNames()
    {
        return names;
    }
    
    /**
     * @return the first name of the flag
     */
    public String getName()
    {
        return names[0];
    }
    
    /**
     * @return a new instance of the class asigned to this type or null if failed and prints stack trace.
     */
    public Flag createFlagClass()
    {
        try
        {
            return flagClass.newInstance();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
    private String[] getField(String name)
    {
        for(Field f : flagClass.getFields())
        {
            if(f.getName().equals(name))
            {
                try
                {
                    return (String[])f.get(null);
                }
                catch(Exception e)
                {
                    e.printStackTrace(); // TODO remove
                }
            }
        }
        
        return null;
    }
    
    public String[] getArguments()
    {
        return getField("A");
    }
    
    public String[] getExamples()
    {
        return getField("E");
    }
    
    public String[] getDescription()
    {
        return getField("D");
        
        /*
        try
        {
            return (String[])flagClass.getField("D").get(null);
        }
        catch(Exception e)
        {
        }
        
        return null;
        */
    }
    
    /**
     * Gets the <code>@flag</code> style flag name
     */
    @Override
    public String toString()
    {
        return '@' + names[0];
    }
    
    /*
     *  Static stuff
     */
    
    private static final Map<String, FlagType> nameMap = new HashMap<String, FlagType>();
    private static final Map<Class<? extends Flag>, FlagType> classMap = new HashMap<Class<? extends Flag>, FlagType>();
    
    /**
     * You should not call this method.<br>
     * <br>
     * It is used by the plugin to add the flags to an index map then create and add individual no-flag permissions.
     */
    public static void init()
    {
        Permission parent = new Permission(Permissions.SKIPFLAG_ALL, PermissionDefault.FALSE);
        parent.setDescription("Ignores all flags.");
        Bukkit.getPluginManager().addPermission(parent);
        Permission p;
        
        for(FlagType type : values())
        {
            classMap.put(type.getFlagClass(), type);
            
            for(String name : type.names)
            {
                nameMap.put(name, type);
                
                if(type.hasBit(Bit.NO_SKIP_PERMISSION) || type.hasBit(Bit.NO_STORE))
                {
                    continue;
                }
                
                if(Bukkit.getPluginManager().getPermission(Permissions.SKIPFLAG_PREFIX + name) != null)
                {
                    Messages.debug("permission for flag " + name + " already exists!");
                    continue;
                }
                
                p = new Permission(Permissions.SKIPFLAG_PREFIX + name, PermissionDefault.FALSE);
                p.setDescription("Ignores the " + type + " flag.");
                p.addParent(parent, true);
                Bukkit.getPluginManager().addPermission(p);
            }
        }
    }
    
    /**
     * Get the FlagType object for a flag name or alias.
     * 
     * @param flag
     *            flag name or alias
     * @return FlagType if found or null
     */
    public static FlagType getByName(String flag)
    {
        Validate.notNull(flag);
        
        if(flag.charAt(0) != '@')
        {
            throw new IllegalArgumentException("Flag string must start with @");
        }
        
        return nameMap.get(flag.substring(1).toLowerCase());
    }
    
    /**
     * Get the FlagType object for the specified class.
     * 
     * @param flagClass
     *            flag's .class
     * @return FlagType if found or null
     */
    public static FlagType getByClass(Class<? extends Flag> flagClass)
    {
        return classMap.get(flagClass);
    }
    
    /**
     * Flag bits to configure special behaviour
     */
    public class Bit
    {
        public static final byte NONE = 0;
        
        /**
         * Flag only works in recipes.
         */
        public static final byte RECIPE = 1 << 1;
        
        /**
         * Flag only works on results.
         */
        public static final byte RESULT = 1 << 2;
        
        /**
         * No value is allowed for this flag.
         */
        public static final byte NO_VALUE = 1 << 3;
        
        /**
         * Disables flag from being stored - used on flags that directly affect result's metadata.
         */
        public static final byte NO_STORE = 1 << 4;
        
        /**
         * Disables "false" or "remove" values from removing the flag.
         */
        public static final byte NO_FALSE = 1 << 5;
        
        /**
         * Disables shift+click on the recipe if there is at least one flag with this bit.
         */
        public static final byte NO_SHIFT = 1 << 6;
        
        /**
         * Disables generating a skip permission for this flag
         */
        public static final short NO_SKIP_PERMISSION = 1 << 7;
    }
}