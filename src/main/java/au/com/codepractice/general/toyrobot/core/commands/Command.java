package au.com.codepractice.general.toyrobot.core.commands;

import au.com.codepractice.general.toyrobot.core.domain.GameState;

public interface Command {
    CommandResult apply(final GameState gameState);
}