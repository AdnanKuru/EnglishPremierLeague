import {React} from 'react';
import {Link} from 'react-router-dom';

export const MatchDetailCard = ({teamName,match}) => {
    if (!match) return null;
    const otherTeam = match.homeTeam === teamName ? match.awayTeam : match.homeTeam;
    const otherTeamRoute = `/teams/${otherTeam}`;
    return (
        <div className="MatchDetailCard">
            <h3>Latest Matches</h3>
            <h1>vs <Link to= {otherTeamRoute}>{otherTeam}</Link></h1>
            <h2>{match.date}</h2>
            <h3>{match.matchWinner } won </h3>
        </div>
    );
}

