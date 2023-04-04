package com.olvera.travelguide.home.presentation

sealed interface HomeFilterDialogActions {
    object OnApplyClick: HomeFilterDialogActions
    object OnRestaurantClick: HomeFilterDialogActions
    object OnMuseumClick: HomeFilterDialogActions
    object OnPeoplePlus: HomeFilterDialogActions
    object OnPeopleMinus: HomeFilterDialogActions

}