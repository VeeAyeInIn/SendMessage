package com.grimlytwisted.spigot.sendmessage.core;

import com.grimlytwisted.spigot.sendmessage.commands.Send;
import com.grimlytwisted.spigot.sendmessage.commands.SendAll;
import org.bukkit.plugin.java.JavaPlugin;

public final class SendMessage extends JavaPlugin {

    @Override
    public void onEnable() {
        registerCommands();
    }

    private void registerCommands() {
        this.getCommand("sendmessage").setExecutor(new Send());
        this.getCommand("sendall").setExecutor(new SendAll());
    }
}
