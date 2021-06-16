import { React } from 'react';
import { Link } from 'react-router-dom';
import './YearSelector.scss';

export const YearSelector = ({teamName}) => {
    console.log(teamName);

    let years = [];
    const startYear = process.env.REACT_APP_DATA_START_YEAR;
    const endYear = process.env.REACT_APP_DATA_END_YEAR;
    console.log(startYear);

    for(let i = startYear; i <= endYear;i++){
        years.push(i);
    }

    return (
        <ul className="YearSelector">
            {years.map(year => (
                <li key={year}>
                    <Link to={`/teams/${teamName}/matches/${year}`}>
                        {year} - {parseInt(year)+1}
                    </Link>
                </li>
            ))}
        </ul>
    )
        }
