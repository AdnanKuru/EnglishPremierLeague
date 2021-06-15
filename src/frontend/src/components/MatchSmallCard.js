import { React } from 'react';
import {Link} from 'react-router-dom';

export  const MatchSmallCard = ({match, teamName}) =>  {
    if (!match) return null;
    const otherTeam = match.homeTeam === teamName ? match.awayTeam : match.homeTeam;
    const otherTeamRoute = `/teams/${otherTeam}`;
    return (
        <div className="MatchSmallCard">
            <h3>vs <Link to= {otherTeamRoute}>{otherTeam}</Link></h3>
        </div>
    );
}

