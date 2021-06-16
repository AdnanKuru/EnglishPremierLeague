import {React, useEffect, useState} from 'react';
import {useParams,Link} from 'react-router-dom';
import {MatchDetailCard} from "../components/MatchDetailCard";
import {MatchSmallCard} from "../components/MatchSmallCard";
import  './TeamPage.scss';
import {PieChart} from 'react-minimal-pie-chart';

export const TeamPage = () => {

    const [team, setTeam] = useState({matches: []});
    const {teamName} = useParams();

    useEffect(
        () => {
            const fetchTeam = async () => {
                const response = await fetch(`http://localhost:8080/team/${teamName}`);
                const data = await response.json();
                console.log(data);
                setTeam(data);
            };
            fetchTeam();
        }, [teamName]
    );

    if (!team || !team.teamName) {
        return <h1>Team Not Found</h1>
    }

    return (
        <div className="TeamPage">
            <div className="team-name-section">
                <h1 className="team-name">{team.teamName}</h1>
            </div>
            <div className="win-loss-draw-section">
                Wins / Losses / Draws

                <PieChart
                data={[
                    { title: 'Losses', value: team.totalLosses, color: '#a34d5d'},
                    { title: 'Wins', value: team.totalWins, color: '#4da375'},
                    { title: 'Draws', value: team.totalMatches - (team.totalWins + team.totalLosses), color: '#979797'},

            ]}
                />;


            </div>
            <div className="match-detail-section">
                <h3>Latest Matches</h3>
                <MatchDetailCard teamName = {team.teamName} match={team.matches[0]}/>
            </div>
            {team.matches.slice(1).map(match => <MatchSmallCard teamName = {team.teamName} match={match}/>)}
            <div className="more-link">
                <Link to={`/teams/${teamName}/matches/${process.env.REACT_APP_DATA_END_YEAR}`}> More ></Link>
            </div>
        </div>
    );
}

