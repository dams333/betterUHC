package ch.dams333.betterUHC.commands;

import ch.dams333.betterUHC.BetterUHC;
import ch.dams333.betterUHC.commands.command.HealCommand;
import ch.dams333.betterUHC.commands.command.ReviveCommand;
import ch.dams333.betterUHC.commands.command.StartCommand;

public class CommandsManager {
    BetterUHC main;
    public CommandsManager(BetterUHC betterUHC) {
        this.main = betterUHC;

        main.getCommand("start").setExecutor(new StartCommand(main));
        main.getCommand("heal").setExecutor(new HealCommand(main));
        main.getCommand("revive").setExecutor(new ReviveCommand(main));
    }
}
