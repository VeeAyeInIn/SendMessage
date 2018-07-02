package com.grimlytwisted.spigot.sendmessage.commands;

import com.grimlytwisted.spigot.sendmessage.util.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class Send implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender.hasPermission(Permissions.SEND_MESSAGE) || sender.isOp()) {

            if(args.length > 1) {

                try {

                    String message = "";
                    for(String string : Arrays.copyOfRange(args, 1, args.length)) {
                        message = message.concat(string) + " ";
                    }

                    Player p = Bukkit.getPlayer(args[0]);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', message));

                } catch (Exception e) {
                    sender.sendMessage(ChatColor.RED + "Oops! It seems that player isn't online right now.");
                }

            } else {
                sender.sendMessage(ChatColor.RED + "Not enough arguments! Please include a player name and a message!");
            }
        } else {
            sender.sendMessage(ChatColor.RED +
                    "I'm sorry, but you do not have permission to perform this command. " +
                    "Please contact the server administrators if you believe this is in error."
            );
        }
        return true;
    }
}
