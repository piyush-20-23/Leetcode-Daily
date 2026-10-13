import pandas as pd

def invalid_tweets(df: pd.DataFrame) -> pd.DataFrame:
    
    return df[df['content'].str.len() > 15][['tweet_id']]