package net.poweredbyhate.chatplus;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ChatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (args.length == 1 && sender.hasPermission("chat.mute")) {
           if (args[0].equalsIgnoreCase("mute")) {
               if (ChatPlus.chatMuted == true) {
                   ChatPlus.chatMuted = false;
                   sender.sendMessage(ChatColor.RED + "Chat unmuted");
               } else {
                   ChatPlus.chatMuted = true;
                   sender.sendMessage(ChatColor.RED + "Chat Muted");
               }
           } else if (args[0].equalsIgnoreCase("unmute")) {
               ChatPlus.chatMuted = false;
           }
        }
        return false;
    }
}
