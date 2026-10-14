import pandas as pd

def categorize_products(activities: pd.DataFrame) -> pd.DataFrame:
    group = (
        activities
        .drop_duplicates()
        .groupby('sell_date')['product']
        .agg(
            num_sold = 'count'
            , products = lambda x : ','.join(sorted(x))
        )
        .reset_index()
    )

    return group.sort_values(by = 'sell_date')