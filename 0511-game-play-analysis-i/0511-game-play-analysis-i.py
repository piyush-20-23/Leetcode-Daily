import pandas as pd

def game_analysis(activity: pd.DataFrame) -> pd.DataFrame:
    group = activity.groupby('player_id').min().reset_index()
    #print(group)
    return group[['player_id', 'event_date']].rename(columns = {'event_date' : 'first_login'})