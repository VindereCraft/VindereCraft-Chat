package vinderecraft.chat.events;

// Adventure Imports
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;

// Bukkit Imports
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import vinderecraft.core.Core;

public class PlayerQuit implements Listener {
    // Allows access to 'vinderecraft.core.Core.java'
    private final Core core;
    public PlayerQuit (Core core) {
        this.core = core;
    }

    // Runs when a player quits/leaves
    @EventHandler
    public void onPlayerQuit (PlayerQuitEvent e) {
        TextComponent quitMessage =
                        Component.text("[",
                        TextColor.color(
                                core.Config.readInt("chat", "color.dark-text-color.r"),
                                core.Config.readInt("chat", "color.dark-text-color.g"),
                                core.Config.readInt("chat", "color.dark-text-color.b")
                        ))
                .append(Component.text("-",
                        TextColor.color(
                                core.Config.readInt("chat", "color.text-color.r"),
                                core.Config.readInt("chat", "color.text-color.g"),
                                core.Config.readInt("chat", "color.text-color.b")
                        )))
                .append(Component.text("] ",
                        TextColor.color(
                                core.Config.readInt("chat", "color.dark-text-color.r"),
                                core.Config.readInt("chat", "color.dark-text-color.g"),
                                core.Config.readInt("chat", "color.dark-text-color.b")
                        )))
                .append(Component.text(e.getPlayer().getName(),
                        TextColor.color(
                                core.Config.readInt("chat", "color.highlight-text-color.r"),
                                core.Config.readInt("chat", "color.highlight-text-color.g"),
                                core.Config.readInt("chat", "color.highlight-text-color.b")
                        )))
                .append(Component.text(" has left.",
                        TextColor.color(
                                core.Config.readInt("chat", "color.text-color.r"),
                                core.Config.readInt("chat", "color.text-color.g"),
                                core.Config.readInt("chat", "color.text-color.b")
                        )));
        e.quitMessage(quitMessage);
    }
}
