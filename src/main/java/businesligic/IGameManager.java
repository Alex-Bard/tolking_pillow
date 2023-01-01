package businesligic;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.unions.AudioChannelUnion;

import java.util.List;
import java.util.Map;

public interface IGameManager {

    IGame getGame(Guild guild);

    void startGameForcibly(Guild guild, AudioChannelUnion channel, IPlayer owner,
                           Map<Member, IPlayer> players) throws IllegalStateException;
    void startGame(Guild guild, AudioChannelUnion channel,
                   IPlayer owner, Map<Member, IPlayer> players) throws IllegalStateException;

    //always check users connecting to avoid problems with mute.
    void connectUserToChannel(Guild guild, AudioChannelUnion channel, Member member);
    void print(String text);

    void voteForStop(Guild guild, AudioChannelUnion channel, IPlayer player) throws IllegalStateException;

    void resetVoteForStop(Guild guild, AudioChannelUnion channel, IPlayer whoVoted) throws IllegalStateException;

    void acceptGame(Guild guild, AudioChannelUnion channel, IPlayer whoAccept) throws IllegalStateException;

    void requestPillow(Guild guild, AudioChannelUnion channel, IPlayer whoRequest);

    void resetRequestPillow(Guild guild, AudioChannelUnion channel, IPlayer whoRequest);

    void acceptPillowRequest(Guild guild, AudioChannelUnion channel, IPlayer Who, IPlayer ToWhom);
    void changeMicrophoneStatuses(Map<Member,Boolean> micStatuses);
    void markGameNotActual(IGame game);
}
