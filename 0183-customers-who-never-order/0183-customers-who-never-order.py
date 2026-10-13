import pandas as pd

def find_customers(adf: pd.DataFrame, bdf: pd.DataFrame) -> pd.DataFrame:
    #print(pd.merge(adf, bdf, how = 'left', left_on = 'id', right_on = 'customerId'))

    df_merged = pd.merge(adf, bdf, how = 'left', left_on = 'id', right_on = 'customerId')
    never_ordered = df_merged[df_merged['customerId'].isna()]

#    print(df_missing)
    return never_ordered[['name']].rename(columns = {'name' : 'Customers'})