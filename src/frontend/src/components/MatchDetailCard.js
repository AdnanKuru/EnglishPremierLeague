import {React} from 'react';
import {Link} from 'react-router-dom';
import "./MatchDetailCard.scss";

export const MatchDetailCard = ({teamName, match}) => {
    if (!match) return null;
    const otherTeam = match.homeTeam === teamName ? match.awayTeam : match.homeTeam;
    const otherTeamRoute = `/teams/${otherTeam}`;
    const isMatchWon = teamName === match.matchWinner;
    return (
        <div className={isMatchWon ? 'MatchDetailCard won-card' : 'MatchDetailCard lost-card'}>
            <div>
                <span className="vs">vs</span>
                <h1><Link to={otherTeamRoute}>{otherTeam}</Link></h1>
                <h2 className="match-date">Date: {match.date}</h2>
                <h3 className="match-result">Score: {match.fullTimeHomeGoal}-{match.fullTimeAwayGoal}</h3>
            </div>
            <div className="additional-detail">
                <h3>{match.homeTeam} last 5 matches</h3>
                <p>{match.homeMatch1}  {match.homeMatch2}  {match.homeMatch3}  {match.homeMatch4}  {match.homeMatch5}</p>
                <h3>{match.awayTeam} last 5 matches</h3>
                <p>{match.awayMatch1}  {match.awayMatch2}  {match.awayMatch3}  {match.awayMatch4}  {match.awayMatch5}</p>
            </div>
        </div>
    );
}

