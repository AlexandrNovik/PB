package aliak.dev.dagger;

import aliak.dev.domain.game.Game;
import aliak.dev.presentation.Table;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAppComponent implements AppComponent {
  private DaggerAppComponent(Builder builder) {
    assert builder != null;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static AppComponent create() {
    return builder().build();
  }

  @Override
  public void inject(Game game) {
    MembersInjectors.<Game>noOp().injectMembers(game);
  }

  @Override
  public void inject(Table table) {
    MembersInjectors.<Table>noOp().injectMembers(table);
  }

  public static final class Builder {
    private Builder() {}

    public AppComponent build() {
      return new DaggerAppComponent(this);
    }
  }
}
