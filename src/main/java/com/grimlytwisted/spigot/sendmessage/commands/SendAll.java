package com.grimlytwisted.spigot.sendmessage.commands;

import com.grimlytwisted.spigot.sendmessage.util.Permissions;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SendAll implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender.hasPermission(Permissions.SEND_ALL) || sender.isOp()) {

            if(args.length > 0) {

                for(Player p : sender.getServer().getOnlinePlayers()) {

                    String message = "";
                    for(String string : args) {
                        message = message.concat(string) + " ";
                    }

                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', message));

                }

            } else {
                sender.sendMessage(ChatColor.RED + "Not enough arguments! Please include a message!");
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
