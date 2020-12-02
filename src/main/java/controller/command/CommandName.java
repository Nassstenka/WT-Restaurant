package controller.command;

public class CommandName {   //!!!!
    public static CommandName ADD_DISH = new CommandName();
    public static CommandName SIGN_IN = new CommandName();
    public static CommandName REGISTER = new CommandName();
    public static CommandName WRONG_REQUEST = new CommandName();

    public CommandName() { }
    public static CommandName valueOf(String name) {
        name = name.toUpperCase();
        switch (name) {
            case "SIGN_IN" : {
                return SIGN_IN;
            }
            case "REGISTER" : {
                return REGISTER;
            }
            case "ADD_DISH" : {
                return ADD_DISH;
            }
            default: {
                return WRONG_REQUEST;
            }
        }
    }
}
