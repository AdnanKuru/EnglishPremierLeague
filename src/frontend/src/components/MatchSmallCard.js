import { React } from 'react';
import {Link} from 'react-router-dom';
import './MatchSmallCard.scss';

export  const MatchSmallCard = ({match, teamName}) =>  {
    if (!match) return null;
    const otherTeam = match.homeTeam === teamName ? match.awayTeam : match.homeTeam;
    const otherTeamRoute = `/teams/${otherTeam}`;
    const isMatchWon = teamName === match.matchWinner;
    return (
        <div className={isMatchWon ? 'MatchSmallCard won-card' : 'MatchSmallCard lost-card'}>
            <span className="vs">vs</span>
            <h1><Link to={otherTeamRoute}>{otherTeam}</Link></h1>
            <h2 >Date: {match.date}</h2>
            <h3 className="match-result">Score: {match.fullTimeHomeGoal } - {match.fullTimeAwayGoal} </h3>
        </div>
    );
}

