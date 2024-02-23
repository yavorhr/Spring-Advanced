package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.view.StatsView;

public interface StatsService {
  void onRequest();
  StatsView getStats();
}
