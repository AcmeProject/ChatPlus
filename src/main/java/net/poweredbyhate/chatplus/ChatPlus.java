package net.poweredbyhate.chatplus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatPlus extends JavaPlugin implements Listener {

    static boolean chatMuted;

    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getCommand("chat").setExecutor(new ChatCommand());
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent ev) {
        Player p = ev.getPlayer();
        if (chatMuted && !p.hasPermission("chat.mute.exempt")) {
            p.sendMessage(ChatColor.RED + "Chat is muted.");
        } else if (p.hasPermission("chat.chat")) {
            return;
        } else {
          p.sendMessage(ChatColor.RED + "You don\'t have permission to chat!");
        }
    }
}
